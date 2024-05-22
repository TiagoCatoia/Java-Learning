public class ExporterFactory {

    private ExporterFactory(){};

    public static Exporter forProductionEnvironment(){ // POLYMORPHIC RETURN TYPE
        return new FileExporter();
    }
    public static Exporter forTestingEnvironment(){ // POLYMORPHIC RETURN TYPE
        return new ConsoleExporter();
    }
}