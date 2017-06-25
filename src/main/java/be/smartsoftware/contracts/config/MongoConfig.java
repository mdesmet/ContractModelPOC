package be.smartsoftware.contracts.config;

import be.smartsoftware.contracts.data.reference.ReferenceCountryReadConverter;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "be.smartsoftware.contracts")
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {
    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "contracts";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    public CustomConversions customConversions() {
        converters.add(new ReferenceCountryReadConverter());
        return new CustomConversions(converters);
    }
}
