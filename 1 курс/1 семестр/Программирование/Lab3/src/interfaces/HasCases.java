package interfaces;

public interface HasCases {
    default String genitiveCase(){return "word";}; // Родительный падеж
    default String dativeCase(){return "word";}; // Дательный падеж
    default String accusativeCase(){return "word";}; // Винительный падеж
    default String instrumentalCase(){return "word";}; // Творительный падеж
    default String prepositionalCase(){return "word";}; // Предложный падеж
}
