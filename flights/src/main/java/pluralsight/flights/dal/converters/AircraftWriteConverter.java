package pluralsight.flights.dal.converters;

import org.springframework.core.convert.converter.Converter;
import org.bson.Document;
import pluralsight.flights.domain.Aircraft;

import javax.print.Doc;

public class AircraftWriteConverter implements Converter<Aircraft, Document> {


    @Override
    public Document convert(Aircraft source) {
        var document = new Document();
        document.put("model",source.getId());
        document.put("capacity",source.getSeatCapacity());
        document.put("wakeTurbulence",source.getWakeTurbulence());

        var modelNameInWords = source.getModel().split(" ");
        if (modelNameInWords.length > 1){
            document.put("Manufacturer",modelNameInWords[0]);
        }else{
            document.put("Manufacturer","N/A");
        }
        return document;
    }
}
