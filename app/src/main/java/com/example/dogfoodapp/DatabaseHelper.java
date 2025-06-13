package com.example.dogfoodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DogFoodApp.db";
    private static final int DATABASE_VERSION = 1;

    // User table
    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_NAME = "username";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PHONE = "phone";
    private static final String COLUMN_USER_ADDRESS = "address";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String COLUMN_USER_ROLE = "role"; // Added to differentiate admin and user

    // Product table
    private static final String TABLE_PRODUCT = "product";
    private static final String COLUMN_PRODUCT_ID = "id";
    private static final String COLUMN_PRODUCT_NAME = "name";
    private static final String COLUMN_PRODUCT_DESCRIPTION = "description";
    private static final String COLUMN_PRODUCT_PRICE = "price";
    private static final String COLUMN_PRODUCT_CATEGORY = "category";
    private static final String COLUMN_PRODUCT_BRAND = "brand";
    private static final String COLUMN_PRODUCT_AGE = "age";
    private static final String COLUMN_PRODUCT_IMAGE_RESOURCE_ID = "image_resource_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT,"
                + COLUMN_USER_PHONE + " TEXT,"
                + COLUMN_USER_ADDRESS + " TEXT,"
                + COLUMN_USER_PASSWORD + " TEXT,"
                + COLUMN_USER_ROLE + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
        Log.d("DatabaseHelper", "User table created");

        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
                + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PRODUCT_NAME + " TEXT,"
                + COLUMN_PRODUCT_DESCRIPTION + " TEXT,"
                + COLUMN_PRODUCT_PRICE + " REAL,"
                + COLUMN_PRODUCT_CATEGORY + " TEXT,"
                + COLUMN_PRODUCT_BRAND + " TEXT,"
                + COLUMN_PRODUCT_AGE + " TEXT,"
                + COLUMN_PRODUCT_IMAGE_RESOURCE_ID + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCT_TABLE);
        Log.d("DatabaseHelper", "Product table created");

        // Insert an admin user
        ContentValues adminValues = new ContentValues();
        adminValues.put(COLUMN_USER_NAME, "admin");
        adminValues.put(COLUMN_USER_EMAIL, "admin@example.com");
        adminValues.put(COLUMN_USER_PHONE, "1234567890");
        adminValues.put(COLUMN_USER_ADDRESS, "Admin Address");
        adminValues.put(COLUMN_USER_PASSWORD, "adminpass");
        adminValues.put(COLUMN_USER_ROLE, "admin");
        long result = db.insert(TABLE_USER, null, adminValues);
        Log.d("DatabaseHelper", "Admin user inserted: " + result);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }

    public boolean registerUser(String username, String email, String phone, String address, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, username);
        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PHONE, phone);
        values.put(COLUMN_USER_ADDRESS, address);
        values.put(COLUMN_USER_PASSWORD, password);
        values.put(COLUMN_USER_ROLE, "user"); // Default role is user

        long result = db.insert(TABLE_USER, null, values);
        db.close();
        Log.d("DatabaseHelper", "User registered: " + result);
        return result != -1;
    }

    public Cursor getUser(String usernameEmail, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_USER, null, "(" + COLUMN_USER_NAME + "=? OR " + COLUMN_USER_EMAIL + "=?) AND " + COLUMN_USER_PASSWORD + "=?", new String[]{usernameEmail, usernameEmail, password}, null, null, null);
    }

    public Cursor getUserProfile(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_USER, null, COLUMN_USER_ID + "=?", new String[]{String.valueOf(userId)}, null, null, null);
    }

    public boolean updateUserProfile(int userId, String name, String email, String phone, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, name);
        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PHONE, phone);
        values.put(COLUMN_USER_ADDRESS, address);

        int result = db.update(TABLE_USER, values, COLUMN_USER_ID + "=?", new String[]{String.valueOf(userId)});
        db.close();
        Log.d("DatabaseHelper", "User profile updated: " + result);
        return result > 0;
    }

    public boolean isAdmin(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, null, COLUMN_USER_ID + "=? AND " + COLUMN_USER_ROLE + "=?", new String[]{String.valueOf(userId), "admin"}, null, null, null);
        boolean isAdmin = cursor != null && cursor.moveToFirst();
        cursor.close();
        db.close();
        Log.d("DatabaseHelper", "Is admin: " + isAdmin);
        return isAdmin;
    }

    public boolean addProduct(String name, String description, double price, String category, String brand, String age, int imageResourceId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, name);
        values.put(COLUMN_PRODUCT_DESCRIPTION, description);
        values.put(COLUMN_PRODUCT_PRICE, price);
        values.put(COLUMN_PRODUCT_CATEGORY, category);
        values.put(COLUMN_PRODUCT_BRAND, brand);
        values.put(COLUMN_PRODUCT_AGE, age);
        values.put(COLUMN_PRODUCT_IMAGE_RESOURCE_ID, imageResourceId);

        long result = db.insert(TABLE_PRODUCT, null, values);
        db.close();
        Log.d("DatabaseHelper", "Product added: " + result);
        return result != -1;
    }

    public boolean updateProduct(int id, String name, String description, double price, String category, String brand, String age, int imageResourceId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, name);
        values.put(COLUMN_PRODUCT_DESCRIPTION, description);
        values.put(COLUMN_PRODUCT_PRICE, price);
        values.put(COLUMN_PRODUCT_CATEGORY, category);
        values.put(COLUMN_PRODUCT_BRAND, brand);
        values.put(COLUMN_PRODUCT_AGE, age);
        values.put(COLUMN_PRODUCT_IMAGE_RESOURCE_ID, imageResourceId);

        int result = db.update(TABLE_PRODUCT, values, COLUMN_PRODUCT_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        Log.d("DatabaseHelper", "Product updated: " + result);
        return result > 0;
    }

    public boolean deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_PRODUCT, COLUMN_PRODUCT_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        Log.d("DatabaseHelper", "Product deleted: " + result);
        return result > 0;
    }

    public Cursor getAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_PRODUCT, null);
    }

    public Cursor searchProducts(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        String searchQuery = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " +
                COLUMN_PRODUCT_NAME + " LIKE ? OR " +
                COLUMN_PRODUCT_BRAND + " LIKE ? OR " +
                COLUMN_PRODUCT_CATEGORY + " LIKE ? OR " +
                COLUMN_PRODUCT_AGE + " LIKE ?";
        return db.rawQuery(searchQuery, new String[]{"%" + query + "%", "%" + query + "%", "%" + query + "%", "%" + query + "%"});
    }
}
