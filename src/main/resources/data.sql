INSERT INTO BRAND (BRAND_NAME, DESCRIPTION) VALUES
  ('OTTO', 'OTTO'),
  ('ZERO', 'ZERO'),
  ('UCB', 'UCB'),
  ('ALLEN SOLLY', 'ALLEN SOLLY');

INSERT INTO SELLER (SELLER_NAME, DESCRIPTION) VALUES
  ('CLOUDRETAIL', 'CLOUDRETAIL'),
  ('COLOR', 'COLOR'),
  ('EBUY', 'EBUY'),
  ('KING', 'KING');
  
INSERT INTO SHIRT (BRAND_ID, DESCRIPTION, TYPE, PRICE, COLOR, SIZE, SKU, SELLER_ID) VALUES
  (1, 'Best Otto Linen', 'Full', 1000, 'Red', 40, 1, 1),
  (2, 'Zero Cotton', 'Half', 2000, 'Green', 38, 2, 1),
  (3, 'UCB Colors', 'Full', 3000, 'Blue', 39, 3, 2),
  (4, 'Allen Solly Silk', 'Half', 1500, 'White', 40, 5, 3),
  (4, 'Allen Solly Cotton', 'Full', 2500, 'Yellow', 42, 10, 4);
  
  INSERT INTO PANT (BRAND_ID, DESCRIPTION, TYPE, PRICE, COLOR, SIZE, SKU, SELLER_ID) VALUES
  (1, 'Best Otto Linen', 'Full', 1000, 'White', 32, 1, 2),
  (2, 'Zero Cotton', 'Half', 2000, 'Green', 34, 2, 3),
  (3, 'UCB Colors', 'Full', 3000, 'Blue', 34, 3, 4),
  (4, 'Allen Solly Silk', 'Half', 1500, 'White', 40, 5, 1),
  (4, 'Allen Solly Cotton', 'Full', 2500, 'Yellow', 42, 10, 1);
  
   INSERT INTO SOCK (BRAND_ID, DESCRIPTION, TYPE, PRICE, COLOR, SIZE, SKU, SELLER_ID) VALUES
  (1, 'Best Otto Linen', 'Full', 1000, 'Red', 40, 1, 2),
  (2, 'Zero Cotton', 'Half', 2000, 'Green', 38, 2, 3),
  (3, 'UCB Colors', 'Full', 3000, 'Blue', 39, 3, 4),
  (4, 'Allen Solly Silk', 'Half', 1500, 'White', 40, 5, 1),
  (4, 'Allen Solly Cotton', 'Full', 2500, 'Yellow', 42, 10, 1);
  
   INSERT INTO CAP (BRAND_ID, DESCRIPTION, TYPE, PRICE, COLOR, SIZE, SKU, SELLER_ID) VALUES
  (1, 'Best Otto Linen', 'Full', 1000, 'Red', 40, 1, 1),
  (2, 'Zero Cotton', 'Half', 2000, 'Green', 38, 2, 1),
  (3, 'UCB Colors', 'Full', 3000, 'Blue', 39, 3, 1),
  (4, 'Allen Solly Silk', 'Half', 1500, 'White', 40, 5, 2),
  (4, 'Allen Solly Cotton', 'Full', 2500, 'Yellow', 42, 10, 3);