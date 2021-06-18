package com.cts.springbatch.csvtodb.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cts.springbatch.csvtodb.model.Product;

@Configuration
public class BatchConfig {
	
	
	@Autowired
	private JobBuilderFactory jbf;
	
	@Autowired
	private StepBuilderFactory sbf;
	
	@Bean
	public Job job() {
		return jbf.get("j2")
				.incrementer(new RunIdIncrementer())
				.start(step()).build();
	}
	
	@Bean
	public Step step() {
		// TODO Auto-generated method stub
		return sbf.get("s1")
				.<Product, Product>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public ItemReader<Product> reader() {
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		
		//set the resource
		reader.setResource(new ClassPathResource("products.csv"));
		
		//read the data from the csv
		
		//read the line
		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
		
		//seperates the date with the token ,
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		//setting the segerated data to the model through it's fields
		lineTokenizer.setNames("id", "name", "description", "price");
		
		//convert it to actual bean object
		BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Product.class);
		
		//set the tokenizer and fieldSetMapper to lineMapper
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		//set linemapper to reader
		reader.setLineMapper(lineMapper);
		
		return reader;
	}
	
	@Bean
	public ItemProcessor<Product, Product> processor() {
		return (p) -> {
			p.setPrice(p.getPrice() - p.getPrice()*0.1); //apply logic of processing 10% discount
			return p;
		};
	}
	
	@Bean
	public ItemWriter<Product> writer() {
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		writer.setSql("INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE) VALUES (:id, :name, :description, :price)"); //named parameters and the name should be same as that of variables in Model
		return writer;
	}
	
	//setting sql datasource
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/batchdb");
		dataSource.setUsername("root");
		dataSource.setPassword("cts");
		return dataSource;
		
	}

}
