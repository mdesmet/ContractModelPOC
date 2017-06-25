package be.smartsoftware.contracts.data.reference;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReferenceCountryReadConverter implements Converter<DBObject, ReferenceCountry> {
    @Override
    public ReferenceCountry convert(DBObject document) {
        BasicDBList currencyList = (BasicDBList) document.get("currency");
        if(currencyList.isEmpty())
            return null;
        return ReferenceCountry.builder()
                .name(((BasicDBObject) document.get("name")).get("official").toString())
                .currency(currencyList.get(0).toString())
                .code(document.get("cca2").toString())
                .build();

    }
}
