package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;//Add the necessary libraries for connecting the database

public class Main {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/products";
        String username = "postgres";
        String password = "020702240777s";// database connection by url, username and password
        int sum=0;//variable for counting the check ( sum of the order )

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected successfully");
            Statement statement = connection.createStatement();//action for connection
            Scanner scanner = new Scanner(System.in);//inputting the position
            int order = 0;
            int whoAreYou = 0;// position
            int chooseOption = 0;// choosing the position
            while (whoAreYou != 3) {// only 2 options for position
                System.out.println("Who are you?\n 1.Manager\n 2.User\n 3.Exit the program");// outputting all options
                whoAreYou = scanner.nextInt();//scanner
                switch (whoAreYou) {//operator switch for using of cases
                    case 1:
                        while (chooseOption != 7) {//
                            System.out.println("1.Insert baking\n 2.Delete baking\n 3.Insert delivery \n 4.Delete delivery \n 5.Insert drink \n 6.Delete drinks \n 7.Exit");
                            chooseOption = scanner.nextInt();
                            switch (chooseOption) {
                                case 1:
                                    System.out.println("Write the name ");// entering the data for inserts
                                    String name = scanner.next();
                                    System.out.println("Write the composition ");
                                    String composition = scanner.next();
                                    System.out.println("Write the price ");
                                    double price = scanner.nextDouble();
                                    System.out.println("Write the calories ");
                                    int calories = scanner.nextInt();
                                    System.out.println("Write the quantity ");
                                    int quantity = scanner.nextInt();
                                    Products baking = new Baking(composition, calories, price, name);//polymorphism
                                    String addSql = "Insert into baking (id, price, calories, availability, quantity, composition, name)values (?,?,?,?,?,?,?)";
                                    PreparedStatement statementAdd = connection.prepareStatement(addSql);
                                    statementAdd.setInt(1, baking.getId());//using of methods
                                    statementAdd.setDouble(2, baking.getPrice());
                                    statementAdd.setDouble(3, baking.getCalories());
                                    statementAdd.setBoolean(4, baking.isAvailability());
                                    statementAdd.setInt(5, quantity);
                                    statementAdd.setString(6, baking.getComposition());
                                    statementAdd.setString(7, baking.getName());
                                    int rowsInserted = statementAdd.executeUpdate();
                                    if (rowsInserted > 0) {
                                        System.out.println("Baking was inserted successfully");//outputting the message about successful insert
                                        break;
                                    }

                                case 2:
                                    System.out.println("Which product you wanna delete?");
                                    int deletebByid = scanner.nextInt();//inputting the id for deleting
                                    String deleteBSql = "DELETE FROM baking WHERE id=?;";
                                    PreparedStatement statementDeleteB = connection.prepareStatement(deleteBSql);
                                    statementDeleteB.setInt(1, deletebByid);
                                    int bakingDeleted = statementDeleteB.executeUpdate();
                                    if (bakingDeleted > 0) {//condition
                                        System.out.println("Baking was deleted successfully");
                                        break;
                                    }
                                case 3:

                                    System.out.println("Write address of delivery");
                                    String address = scanner.next();//inputting for inserting the address
                                    Delivery delivery = new Delivery(address);
                                    String addSqlD = "Insert into delivery (id, address )values (?,?)";//sql query
                                    PreparedStatement statementAddD = connection.prepareStatement(addSqlD);
                                    statementAddD.setInt(1, delivery.getId());//methods from class delivery
                                    statementAddD.setString(2, delivery.getAddress());
                                    int addressesInserted = statementAddD.executeUpdate();
                                    if (addressesInserted > 0) {//condition
                                        System.out.println("Address was inserted successfully");
                                        break;
                                    }
                                    break;
                                case 4:
                                    System.out.println("Which delivery do you wanna delete?");
                                    int deletebDyid = scanner.nextInt();//inputting for deleting delivery
                                    String deleteDSql = "DELETE FROM delivery WHERE id=?;";
                                    PreparedStatement statementDeleteD = connection.prepareStatement(deleteDSql);
                                    statementDeleteD.setInt(1, deletebDyid);
                                    int addressDeleted = statementDeleteD.executeUpdate();
                                    if (addressDeleted > 0) {
                                        System.out.println("Address was deleted successfully");
                                        break;
                                    }
                                case 5:
                                    System.out.println("Write the name");
                                    String namedr = scanner.next();//inputting whole data for inserting the drinks
                                    System.out.println("Write the price");
                                    double pricedr = scanner.nextDouble();
                                    System.out.println("Write the calories");
                                    double caloriesdr = scanner.nextDouble();
                                    System.out.println("Write the quantity");
                                    int quantitydr = scanner.nextInt();
                                    System.out.println("Write the Volume");
                                    double volumedr = scanner.nextDouble();
                                    System.out.println("Write aerated status");
                                    boolean aerated = scanner.nextBoolean();
                                    System.out.println("Write alcoholic status");
                                    boolean alcoholic = scanner.nextBoolean();
                                    Drinks drinks = new Drinks(volumedr, aerated, alcoholic, caloriesdr, pricedr, namedr);
                                    String addSqldr = "Insert into drinks (id, price, calories, availability, volume, aerated, alcoholic, quantity, name)values (?,?,?,?,?,?,?,?,?)";//sql query
                                    PreparedStatement statementAdddr = connection.prepareStatement(addSqldr);
                                    statementAdddr.setInt(1, drinks.getId());//methods from class drinks
                                    statementAdddr.setDouble(2, drinks.getPrice());
                                    statementAdddr.setDouble(3, drinks.getCalories());
                                    statementAdddr.setBoolean(4, drinks.isAvailability());
                                    statementAdddr.setDouble(5, drinks.volume);
                                    statementAdddr.setBoolean(6, drinks.isAerated());
                                    statementAdddr.setBoolean(7, drinks.isAlcoholic());
                                    statementAdddr.setInt(8, quantitydr);
                                    statementAdddr.setString(9, drinks.getName());
                                    int rowsDRInserted = statementAdddr.executeUpdate();
                                    if (rowsDRInserted > 0) {
                                        System.out.println("Drink was inserted successfully");
                                        break;
                                    }
                                case 6:

                                    System.out.println("Which drink you wanna delete?");
                                    int deleteDByid = scanner.nextInt();// inputting id for delete drink
                                    String deleteSqldr = "DELETE FROM drinks WHERE id=?;";
                                    PreparedStatement statementDeleteDr = connection.prepareStatement(deleteSqldr);
                                    statementDeleteDr.setInt(1, deleteDByid);
                                    int rowsDRDeleted = statementDeleteDr.executeUpdate();
                                    if (rowsDRDeleted > 0) {
                                        System.out.println("Drink was deleted successfully");
                                        break;
                                    }

                            }


                        }
                        break;
                    case 2:
                        while (chooseOption != 4) {
                            System.out.println("Wellcum to the shop, baddy.\nWhich option do you wanna choose?\n1.Press 1 to see all products.\n2.Press 2 to make an order for delivery.\n3.Press 3 to see all special sales.\n4.Exit");
                            chooseOption = scanner.nextInt();
                            switch (chooseOption) {

                                case 1://case for viewing the products
                                    while (chooseOption != 3) {
                                        System.out.println("1.See baking products\n 2.See drinks\n");
                                        chooseOption = scanner.nextInt();
                                        switch (chooseOption) {//another switch for cases
                                            case 1://case for viewing the baking products
                                                String SQL = "SELECT * FROM baking";//sql query
                                                ResultSet resultSet = statement.executeQuery(SQL);

                                                while (resultSet.next()) {
                                                    int id = resultSet.getInt(1);
                                                    double price = resultSet.getDouble(2);
                                                    double calories = resultSet.getDouble(3);
                                                    boolean availability = resultSet.getBoolean(4);
                                                    int quantity = resultSet.getInt(5);
                                                    String composition = resultSet.getString(6);
                                                    String name = resultSet.getString(7);

                                                    System.out.println("id: " + id);
                                                    System.out.println("price: " + price);
                                                    System.out.println("calories: " + calories);
                                                    System.out.println("availability: " + availability);
                                                    System.out.println("quantity: " + quantity);
                                                    System.out.println("composition: " + composition);
                                                    System.out.println("name: " + name);


                                                }
                                                break;
                                            case 2://case for viewing the drinks
                                                String SQLd = "SELECT * FROM drinks";//privet
                                                ResultSet resultSetd = statement.executeQuery(SQLd);

                                                while (resultSetd.next()) {
                                                    int id = resultSetd.getInt(1);//andrey
                                                    double price = resultSetd.getDouble(2);
                                                    double calories = resultSetd.getDouble(3);
                                                    boolean availability = resultSetd.getBoolean(4);
                                                    int quantity = resultSetd.getInt(5);
                                                    double volume = resultSetd.getDouble(6);
                                                    boolean aerated = resultSetd.getBoolean(7);//tutururu
                                                    boolean alcoholic = resultSetd.getBoolean(8);
                                                    String name = resultSetd.getString(9);
                                                    System.out.println("id: " + id);
                                                    System.out.println("price: " + price);
                                                    System.out.println("calories: " + calories);
                                                    System.out.println("availability: " + availability);
                                                    System.out.println("quantity: " + quantity);
                                                    System.out.println("volume: " + volume);
                                                    System.out.println("aerated: " + aerated);
                                                    System.out.println("alcoholic: " + alcoholic);
                                                    System.out.println("name: " + name);

                                                }
                                                break;


                                        }


                                    }
                                case 2://case for order by delivery
                                    System.out.println("Enter your address");
                                    String uadress = scanner.next();
                                    String SQL = "SELECT * FROM delivery";
                                    ResultSet resultSetde = statement.executeQuery(SQL);
                                    int k = 0;
                                    while (resultSetde.next()) {
                                        String address = resultSetde.getString(2);
                                        if (uadress.equalsIgnoreCase(address)) {
                                            k++;
                                        }
                                    }
                                    if (k > 0) {
                                        int choosetype = 0;
                                        while (choosetype != 4) {
                                            System.out.println("Type 1 to make order of baking. \n Type 2 to make order of drinks \n Type 3 to check price of the order.\n Type 4 to exit.");
                                            choosetype = scanner.nextInt();
                                            switch (choosetype) {
                                                case 1://case for making an order for baking products
                                                    String SQLde = "SELECT * FROM baking";
                                                    ResultSet resultSet = statement.executeQuery(SQLde);
                                                    int choosede = 0;


                                                    while (choosede!=10) {
                                                        System.out.println("There is list of products:");
                                                        while (resultSet.next()) {
                                                            int id = resultSet.getInt(1);
                                                            double price = resultSet.getDouble(2);
                                                            double calories = resultSet.getDouble(3);
                                                            boolean availability = resultSet.getBoolean(4);
                                                            int quantity = resultSet.getInt(5);
                                                            String composition = resultSet.getString(6);
                                                            String name = resultSet.getString(7);

                                                            System.out.println("id: " + id);
                                                            System.out.println("price: " + price);
                                                            System.out.println("calories: " + calories);
                                                            System.out.println("availability: " + availability);
                                                            System.out.println("quantity: " + quantity);
                                                            System.out.println("composition: " + composition);
                                                            System.out.println("name: " + name);
                                                        }

                                                        System.out.println("Make order by id of products\nType 10 to exit.");
                                                        choosede = scanner.nextInt();
                                                        PreparedStatement statementdeB = connection.prepareStatement("SELECT * FROM baking where id = ?");
                                                        statementdeB.setInt(1,choosede);
                                                        ResultSet resultset = statementdeB.executeQuery();
                                                        while (resultset.next()){
                                                            sum=sum+resultset.getInt(2);}//math function for calculating the total price of the order
                                                        String sqlUpdB="UPDATE baking set quantity=(quantity-1) where id = ?";//sssssql
                                                        PreparedStatement statement1 = connection.prepareStatement(sqlUpdB);
                                                        statement1.setInt(1,choosede);
                                                        int rowsBSale = statement1.executeUpdate();
                                                        if (rowsBSale > 0) {//condition
                                                            System.out.println("Baking was sold");
                                                            break;
                                                        }

                                                        break;
                                                    }
                                                    break;
                                                case 2:// case for making an order for drinks
                                                    String SQLdedr = "SELECT * FROM drinks";
                                                    ResultSet resultSetdr = statement.executeQuery(SQLdedr);
                                                    int choosededr = 0;


                                                    while (choosededr!=10) {//spat hochu
                                                        System.out.println("There is list of products:");
                                                        while (resultSetdr.next()) {
                                                            int id = resultSetdr.getInt(1);//methods
                                                            double price = resultSetdr.getDouble(2);
                                                            double calories = resultSetdr.getDouble(3);
                                                            boolean availability = resultSetdr.getBoolean(4);
                                                            int quantity = resultSetdr.getInt(5);
                                                            double volume = resultSetdr.getDouble(6);
                                                            boolean aerated = resultSetdr.getBoolean(7);
                                                            boolean alcoholic = resultSetdr.getBoolean(8);
                                                            String name = resultSetdr.getString(9);
                                                            System.out.println("id: " + id);
                                                            System.out.println("price: " + price);
                                                            System.out.println("calories: " + calories);
                                                            System.out.println("availability: " + availability);
                                                            System.out.println("quantity: " + quantity);
                                                            System.out.println("volume: " + volume);
                                                            System.out.println("aerated: " + aerated);
                                                            System.out.println("alcoholic: " + alcoholic);
                                                            System.out.println("name: " + name);
                                                        }

                                                        System.out.println("Make order by id of products\nType 10 to exit.");
                                                        choosededr = scanner.nextInt();
                                                        PreparedStatement statementdeB = connection.prepareStatement("SELECT * FROM drinks where id = ?");
                                                        statementdeB.setInt(1,choosededr);
                                                        ResultSet resultset = statementdeB.executeQuery();
                                                        while (resultset.next()){
                                                            sum=sum+resultset.getInt(2);}
                                                        String sqlUpdB="UPDATE drinks set quantity=(quantity-1) where id = ?";
                                                        PreparedStatement statement1 = connection.prepareStatement(sqlUpdB);
                                                        statement1.setInt(1,choosededr);
                                                        int rowsBSale = statement1.executeUpdate();
                                                        if (rowsBSale > 0) {
                                                            System.out.println("Drink was sold");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Price of the order is "+sum);
                                                    break;
                                            }
                                        }
                                    } else{ System.out.println("Sorry we cant deliver the products to your address yet.");}
                                case 3://case for viewing sales
                                    String SQLss = "select * from sales order by RANDOM() limit 1";//sql query that randomly represents sale
                                    ResultSet resultSet = statement.executeQuery(SQLss);


                                    while (resultSet.next()) {
                                        String names = resultSet.getString("name");


                                        System.out.println("name: " + names);
                                    }
                            }


                        }


                }
            }
        }

        catch (SQLException throwables) {
            System.out.println("Error in connecting");
            throwables.printStackTrace();
        }

    }
}