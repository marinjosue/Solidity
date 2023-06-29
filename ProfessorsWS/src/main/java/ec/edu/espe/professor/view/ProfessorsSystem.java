package ec.edu.espe.professor.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import ec.edu.espe.professor.model.Professor;
import org.bson.Document;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */



public class ProfessorsSystem extends Professor{
    private static final String CONNECTION_STRING = "mongodb+srv://yeshua:yeshua@cluster0.zwf1ijm.mongodb.net/";

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    private static Gson gson;
    private static GsonBuilder gsonBuilder;
    private static Scanner scanner;

    public static void main(String[] args) {
        gson = new Gson();
        gsonBuilder = new GsonBuilder();
        scanner = new Scanner(System.in);

        // Conexión a MongoDB Atlas
        connectToDatabase();

        // Menú de opciones
        boolean exit = false;
        while (!exit) {
            System.out.println("----- MENU -----");
            System.out.println("1. Read Members");
            System.out.println("2. Add Members");
            System.out.print("enter an opcion: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    mostrarDatos();
                    break;
                case 2:
                    agregarDato();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        }

        // Cierre de recursos
        mongoClient.close();
        scanner.close();
    }

    public static void connectToDatabase() {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("University");
        collection = database.getCollection("Professors");
    }

    public static void mostrarDatos() {
        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        System.out.println("Datos en la base de datos:");
        for (Document documento : documentos) {
            // Convertir el documento a JSON y mostrarlo en la consola
            String json = documento.toJson();
            System.out.println(json);
            
        }

        // Obtener la cantidad de documentos en la colección
        long cantidad = collection.countDocuments();
        System.out.println("Cantidad de datos: " + cantidad);
    }

    public static void agregarDato() {
        System.out.println("Ingrese los datos:");

        System.out.print("name: ");
        String name = scanner.nextLine();
        
        
        System.out.print("subject: ");
        String subject = scanner.nextLine();
        

        System.out.print("educational_level: ");
        String educational_level = scanner.nextLine();
        
        
        System.out.print("experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("email: ");
        String email = scanner.nextLine();
        scanner.nextLine();
        
        // Crear objeto y convertirlo a JSON
        Professor professor = new Professor(name, subject, educational_level, experience, email);
        String json = gson.toJson(professor);

        // Insertar el documento JSON en MongoDB
        Document document = Document.parse(json);
        collection.insertOne(document);

        System.out.println("Dato agregado correctamente.");
    }
    
    public ProfessorsSystem(String name, String subject, String educational_level, int experience, String email) {
        super(name, subject, educational_level, experience, email);
    }
}