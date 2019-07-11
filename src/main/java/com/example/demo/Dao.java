package com.example.demo;

public class Dao {
    /*private static void fillDatabase() {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {

            try (Statement st = con.createStatement()) {

                con.setAutoCommit(false);

                // создаём таблицу
                st.addBatch("DROP TABLE IF EXISTS " + TABLE_NAME);
                st.addBatch("CREATE TABLE " + TABLE_NAME + "(" +
                        "ssoid VARCHAR(256)," +
                        "ts VARCHAR(256), " +
                        "grp VARCHAR(256), " +
                        "type VARCHAR(256), " +
                        "subtype VARCHAR(256), " +
                        "url VARCHAR(256), " +
                        "orgid VARCHAR(256), " +
                        "formid VARCHAR(256), " +
                        "code VARCHAR(256), " +
                        "ltpa VARCHAR(256), " +
                        "sudirresponse VARCHAR(256), " +
                        "ymdh VARCHAR(256))");
                try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
                    String line;
                    boolean isFirst = true;
                    while ((line = br.readLine()) != null) {
                        // пропускаем первую строку
                        if (isFirst) {
                            isFirst = false;
                            continue;
                        }

                        // создаём очередной insert
                        String query = createQuery(line);
                        if (query.isEmpty()) {
                            continue;
                        }

                        // добавляем очередной insert
                        try {
                            st.addBatch(query);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // выполняем SQL запрос
                st.executeBatch();
                con.commit();

            } catch (SQLException exl1) {

                if (con != null) {
                    try {
                        con.rollback();
                    } catch (SQLException ex12) {
                        System.out.println(ex12.getMessage());
                    }
                }

                System.out.println(exl1.getMessage());
            }
        } catch (SQLException exl3) {
            System.out.println(exl3.getMessage());
        }
    }*/

}
