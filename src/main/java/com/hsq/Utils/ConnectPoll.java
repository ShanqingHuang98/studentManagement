//package com.hsq.Utils;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.SQLFeatureNotSupportedException;
//import java.util.LinkedList;
//import java.util.Properties;
//import java.util.logging.Logger;
//
//public class ConnectPoll implements DataSource {
//    private static LinkedList<Connection> connPool = new LinkedList<Connection>();
//
//    static {
//        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
//        Properties properties = new Properties();
//
//        try {
//            properties.load(inputStream);
//            String driver = properties.getProperty("driver");
//            String url = properties.getProperty("url");
//            String username = properties.getProperty("username");
//            String password = properties.getProperty("password");
//
//            // 初始连接数大小未知
//            int initSize = 50;
//            Class.forName(driver);
//            for (int i = 0; i < initSize; i++) {
//                Connection conn = DriverManager.getConnection(url, username, password);
//                System.out.println("初始化数据库连接池，创建第 " + (i + 1) + "个连接，添加到连接池中");
//                connPool.add(conn);
//            }
//
//        } catch (ClassNotFoundException | IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * get database connection
//     */
//
//
//    @Override
//    public  Connection getConnection() {
//        if (connPool.size() > 0) {
//            final Connection conn = connPool.removeFirst();
//
//            return (Connection) Proxy.newProxyInstance(ConnectPoll.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    if (!"close".equals(method.getName())) {
//                        return method.invoke(conn, args);
//                    } else {
//                        connPool.add(conn);
//                        System.out.println("close the connection and return to the pool");
//                        System.out.println("the number of connection in the pool is: " + connPool.size());
//                        return null;
//                    }
//                }
//            });
//        } else {
//            throw new RuntimeException("the database is busy,please try it later");
//        }
//
//
//    }
//
//    @Override
//    public Connection getConnection(String username, String password) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public PrintWriter getLogWriter() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void setLogWriter(PrintWriter out) throws SQLException {
//
//    }
//
//    @Override
//    public void setLoginTimeout(int seconds) throws SQLException {
//
//    }
//
//    @Override
//    public int getLoginTimeout() throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//        return null;
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> iface) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public boolean isWrapperFor(Class<?> iface) throws SQLException {
//        return false;
//    }
//}
