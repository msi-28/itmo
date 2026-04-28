package classes;

import java.util.StringJoiner;

public interface Gettable<T extends Enum<T>> {

    static <T extends Enum<T>> String getValues(Class<T> enumClass){
        StringJoiner valuesString = new StringJoiner(", ");
        for (T t : enumClass.getEnumConstants()){
            valuesString.add(t.toString().toLowerCase());
        }
        return valuesString.toString();
    }
}
