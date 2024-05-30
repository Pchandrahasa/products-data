CREATE TABLE Product (
    productId INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);

CREATE TABLE Review (
    reviewId INT AUTO_INCREMENT PRIMARY KEY,
    reviewContent VARCHAR(255) NOT NULL,
    rating INT NOT NULL CHECK (rating >= 1 AND rating <= 5),
    productId INT,
    FOREIGN KEY (productId) REFERENCES Product(productId)
);
