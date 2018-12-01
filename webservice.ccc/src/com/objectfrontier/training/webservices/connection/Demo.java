package com.objectfrontier.training.webservices.connection;

import java.io.IOException;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws SQLException, IOException {

        java.sql.Connection con = new ConnectionManagement().getConnection();
        System.out.println(con);
//        Demo demo = new Demo();
//        demo.print();
//        List<Address> personList = new ArrayList<>();
//        Resource dbResource = new Resource();
//        dbResource.createConnection();
//        AddressService addressService = new AddressService();
//        personList = addressService.readAll(dbResource);
//        personList.forEach(e -> System.out.println(e.getCity()));
////        String data = "nn";
//        String[] option = {"city","street","postal code"};
//        StringBuilder searchQuery = new StringBuilder()
//                .append("SELECT id, street, city, postal_code FROM address WHERE ");
//                for (int i = 0; i < option.length; i++) {
//                if (i > 0) { searchQuery.append(" OR "); }
//                if ("street".equals(option[i])) {
//                searchQuery.append("street LIKE ?");
//                } else if ("city".equals(option[i])) {
//                searchQuery.append("city LIKE ?");
//                } else if ("postal code".equals(option[i])) {
//                searchQuery.append("postal_code LIKE ?");
//                }
//                }
//            PreparedStatement statement = con.prepareStatement(searchQuery.toString());
//            for (int i = 1; i <= option.length; i++ ) {
//                statement.setString(i, "%" + data + "%");
//            }
//            ResultSet result = statement.executeQuery();
//            while (result.next()) {
//                System.out.println(result.getString("street") + result.getLong("id"));
//            }
    }
//            System.out.println(resultSet.getInt("id"));
//        List<Address> addressList = addressService.readAll(con);
//        String[] option = {"street", "city", "postal code"};
//        String[] data = {"MGR Street","cHENNAI", "60113"};
//        List <Address> searchList = new ArrayList<>();
//        for (int i = 0; i < option.length; i++) {
//            String filed = data[i];
//            if ("street".equalsIgnoreCase(option[i])) {
//                searchList.addAll(addressList.stream().filter(address -> { return (address.getStreet().equalsIgnoreCase(filed));})
//                                                      .collect(Collectors.toList()));
//            }
//            if ("city".equalsIgnoreCase(option[i])) {
//                searchList.addAll(addressList.stream().filter(address -> { return (address.getCity().equalsIgnoreCase(filed));})
//                                                      .collect(Collectors.toList()));
//            }
//            if ("postal code".equalsIgnoreCase(option[i])) {
//                searchList.addAll(addressList.stream().filter(address -> { return (address.getPostal_code() == Integer.parseInt(filed));})
//                                                      .collect(Collectors.toList()));
//            }
//        }
//        Set <Address> finalSearchList = searchList.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Address :: getId))));
//        searchList.forEach(e-> System.out.println(e.getId()));
//        searchList.removeAll(searchList);
//        searchList.addAll(finalSearchList);
//        searchList.forEach(e-> System.out.println(e.getId()));
//        String data = "Chennai";
//        System.out.println(data);
//        List<Address> addressList = addressService.readAll(con);
//        List <Address> basedOnStreet = new ArrayList<>();
//        basedOnStreet.addAll(addressList.stream().filter(address -> { return (address.getCity().equalsIgnoreCase(data));}).collect(Collectors.toList()));
//        System.out.println(basedOnStreet.size());
        // TODO Auto-generated method stub
//        List<String> dd = new ArrayList<>();
//        dd.add("Hello");
//        dd.add("Arun");
//        dd.add("kumar");
//        System.out.println(dd);
//        dd.remove(1);
//        dd.add(1, "kumar");;
//        System.out.println(dd);
//        String date = "23-10-1996";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
//        LocalDate date1 = LocalDate.parse(date.subSequence(0, date.length()), formatter);
//        System.out.println(date1);
    }
//    private void print() {
//        // TODO Auto-generated method stub
//        System.out.println(this.getA().trim());
//    }
//    public String getA() {
//        return a;
//    }
//    public void setA(String a) {
//        this.a = a;
//    }

