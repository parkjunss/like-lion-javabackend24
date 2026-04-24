package mini.jdbc.sqls;

public class SqlQuery {
    // User Queries
    public static final String USER_INSERT = "INSERT INTO users (username, password, balance) VALUES (?, ?, ?)";
    public static final String USER_CHECK_EXISTS = "SELECT COUNT(*) FROM users WHERE username = ?";
    public static final String USER_UPDATE_ALL = "UPDATE users SET username = ?, password = ?, balance = ? WHERE id = ?";
    public static final String USER_UPDATE_USERNAME = "UPDATE users SET username = ? WHERE id = ?";
    public static final String USER_UPDATE_PASSWORD = "UPDATE users SET password = ? WHERE id = ?";
    public static final String USER_UPDATE_BALANCE = "UPDATE users SET balance = ? WHERE id = ?";
    public static final String USER_INCREMENT_BALANCE = "UPDATE users SET balance = balance + ? WHERE id = ?";
    public static final String USER_DELETE = "DELETE FROM users WHERE id = ?";
    public static final String USER_GET_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String USER_GET_BY_NAME = "SELECT * FROM users WHERE username = ?";

    // Product Queries
    public static final String PRODUCT_INSERT = "INSERT INTO products (title, content, price, stock_quantity, user_id) VALUES (?,?,?,?,?)";
    public static final String PRODUCT_UPDATE = "UPDATE products SET title = ?, content = ?, price = ?, stock_quantity = ? WHERE id = ?";
    public static final String PRODUCT_UPDATE_STOCK = "UPDATE products SET stock_quantity = stock_quantity + ? WHERE id = ?";
    public static final String PRODUCT_DELETE_WITH_OWNER = "DELETE FROM products WHERE id = ? AND user_id = ?";
    public static final String PRODUCT_GET_BY_ID = "SELECT p.*, u.username FROM products p JOIN users u ON p.user_id = u.id WHERE p.id = ?";
    public static final String PRODUCT_GET_BY_USER = "SELECT p.*, u.username FROM products p JOIN users u ON p.user_id = u.id WHERE p.user_id = ?";
    public static final String PRODUCT_GET_BY_NAME = "SELECT p.*, u.username FROM products p JOIN users u ON p.user_id = u.id WHERE p.title LIKE ?";
    public static final String PRODUCT_GET_ALL = "SELECT p.*, u.username FROM products p JOIN users u ON p.user_id = u.id";

    // Order Queries
    public static final String ORDER_INSERT = "INSERT INTO orders(user_id, product_id, order_price) VALUES(?,?,?)";
    public static final String ORDER_DELETE = "DELETE FROM orders WHERE order_id = ?";
    public static final String ORDER_GET_BY_ID = "SELECT o.*, u.username FROM orders o JOIN users u ON o.user_id = u.id WHERE o.id = ?";
    public static final String ORDER_GET_BY_PRODUCT = "SELECT o.*, u.username, p.title FROM orders o JOIN users u ON o.user_id = u.id JOIN products p ON o.product_id = p.id WHERE o.product_id = ?";
    public static final String ORDER_GET_BY_USER = "SELECT o.*, u.username, p.title FROM orders o JOIN users u ON o.user_id = u.id JOIN products p ON o.product_id = p.id WHERE o.user_id = ?";
}
