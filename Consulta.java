
package com.mycompany.consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Consulta {

public class Main {

    public static void main(String[] args) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "daniuwu11");

            // Crear la consulta
            String query = "SELECT * FROM usuarios";

            // Crear la declaración
            Statement statement = connection.createStatement();

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery(query);

            // Crear una lista para almacenar los resultados
            List<String> usuarios = new ArrayList<>();

            // Recorrer los resultados
            while (resultSet.next()) {
                // Obtener el valor de la columna "nombre" en cada fila y agregarlo a la lista
                String nombreUsuario = resultSet.getString("nombre");
                usuarios.add(nombreUsuario);
            }

            // Cerrar los recursos
            resultSet.close();
            statement.close();
            connection.close();

            // Desplegar la lista de usuarios
            for (String usuario : usuarios) {
                System.out.println(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    }

