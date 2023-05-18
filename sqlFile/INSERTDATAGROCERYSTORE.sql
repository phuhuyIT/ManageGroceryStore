--
INSERT INTO suppliers (suppliercode, fullname, location, phone) 
VALUES
('SUP001', 'ABC Supplier', '123 Main St, City, State', '123-456-7890'),
('SUP002', 'XYZ Supplier', '456 Oak St, City, State', '456-789-0123'),
('SUP003', 'EFG Supplier', '789 Maple St, City, State', '789-012-3456'),
('SUP004', 'HIJ Supplier', '321 Pine St, City, State', '321-654-9870'),
('SUP005', 'KLM Supplier', '654 Cedar St, City, State', '654-987-0123'),
('SUP006', 'NOP Supplier', '987 Birch St, City, State', '987-012-3456'),
('SUP007', 'QRS Supplier', '246 Elm St, City, State', '246-802-4680'),
('SUP008', 'TUV Supplier', '369 Oak St, City, State', '369-135-8024'),
('SUP009', 'WXYZ Supplier', '159 Maple St, City, State', '159-753-0864'),
('SUP010', 'LMN Supplier', '753 Pine St, City, State', '753-159-2468'),
('SUP011', 'DEF Supplier', '246 Cedar St, City, State', '246-753-9510'),
('SUP012', 'GHI Supplier', '369 Birch St, City, State', '369-258-1470'),
('SUP013', 'JKL Supplier', '951 Elm St, City, State', '951-753-2468'),
('SUP014', 'MNO Supplier', '753 Oak St, City, State', '753-951-0864'),
('SUP015', 'PQR Supplier', '468 Maple St, City, State', '468-802-1359'),
('SUP016', 'STU Supplier', '246 Pine St, City, State', '246-468-1359'),
('SUP017', 'VWX Supplier', '369 Cedar St, City, State', '369-802-4681'),
('SUP018', 'YZA Supplier', '753 Birch St, City, State', '753-246-8024'),
('SUP019', 'BCD Supplier', '468 Elm St, City, State', '468-135-8024'),
('SUP020', 'EFG Supplier', '159 Oak St, City, State', '159-802-4681'),
('SUP021', 'HIJ Supplier', '321 Maple St, City, State', '321-654-0987'),
('SUP022', 'KLM Supplier', '654 Pine St, City, State', '654-987-6543'),
('SUP023', 'NOP Supplier', '987 Cedar St, City, State', '987-012-3456'),
('SUP024', 'QRS Supplier', '246 Birch St, City, State', '246-802-4680'),
('SUP025', 'TUV Supplier', '369 Elm St, City, State', '369-135-8024'),
('SUP026', 'WXYZ Supplier', '159 Oak St, City, State', '159-753-0864'),
('SUP027', 'LMN Supplier', '753 Maple St, City, State', '753-159-2468'),
('SUP028', 'DEF Supplier', '246 Pine St, City, State', '246-753-9510'),
('SUP029', 'GHI Supplier', '369 Cedar St, City, State', '369-258-1470'),
('SUP030', 'JKL Supplier', '951 Birch St, City, State', '951-753-2468'),
('SUP031', 'MNO Supplier', '753 Elm St, City, State', '753-951-0864'),
('SUP032', 'PQR Supplier', '468 Oak St, City, State', '468-802-1359'),
('SUP033', 'STU Supplier', '246 Maple St, City, State', '246-468-1359'),
('SUP034', 'VWX Supplier', '369 Pine St, City, State', '369-802-4681'),
('SUP035', 'YZA Supplier', '753 Cedar St, City, State', '753-246-8024'),
('SUP036', 'BCD Supplier', '468 Birch St, City, State', '468-135-8024'),
('SUP037', 'EFG Supplier', '159 Elm St, City, State', '159-802-4681'),
('SUP038', 'HIJ Supplier', '321 Oak St, City, State', '321-654-0987'),
('SUP039', 'KLM Supplier', '654 Maple St, City, State', '654-987-6543'),
('SUP040', 'NOP Supplier', '987 Pine St, City, State', '987-012-3456');
--
INSERT INTO productCategories (name,parent_id) VALUES
('Thực phẩm', NULL),
('Hàng gia dụng',NULL),
('Đồ dùng cá nhân',NULL),
('Vật dụng học tập và văn phòng phẩm',NULL),
('Hóa phẩm và chất tẩy rửa',NULL),
('Đồ chơi và quà tặng',NULL),
('Thuốc và vật dụng y tế',NULL),
('Hoa quả', 2),
('Rau củ', 2),
('Thực phẩm đóng hộp', 3),
('Thực phẩm đóng túi', 3);
-- insert data thêm
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (1, 'Lettuce - Lolla Rosa', 34, 3, 145148, 114691);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (2, 'Pork - Liver', 34, 2, 33742, 167300);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (3, 'Quail - Jumbo Boneless', 7, 10, 110270, 41515);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (4, 'Wine - White, Ej', 1, 5, 50146, 42741);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (5, 'Gatorade - Fruit Punch', 22, 1, 19470, 95708);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (6, 'Salmon - Atlantic, Skin On', 7, 7, 138880, 197200);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (7, 'Beer - Muskoka Cream Ale', 17, 3, 141508, 177155);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (8, 'Bread - Roll, Italian', 3, 8, 136265, 193770);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (9, 'Wine - Piper Heidsieck Brut', 27, 7, 149869, 65262);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (10, 'Anchovy Paste - 56 G Tube', 34, 10, 52915, 68674);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (11, 'Wheat - Soft Kernal Of Wheat', 32, 4, 46153, 163478);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (12, 'Bandage - Finger Cots', 13, 9, 129220, 160602);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (13, 'Pie Shells 10', 10, 7, 180995, 165925);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (14, 'Wine - Pinot Grigio Collavini', 14, 5, 38403, 181049);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (15, 'Versatainer Nc - 9388', 23, 1, 178685, 13597);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (16, 'Tomato Puree', 10, 4, 112097, 110516);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (17, 'Pineapple - Canned, Rings', 29, 7, 30997, 70104);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (18, 'Chervil - Fresh', 36, 1, 27965, 104041);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (19, 'Fond - Neutral', 4, 9, 178568, 140056);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (20, 'Mahi Mahi', 34, 8, 42298, 127842);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (21, 'Bag - Bread, White, Plain', 7, 8, 63327, 86366);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (22, 'Vol Au Vents', 4, 9, 32219, 16969);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (23, 'Beer - Paulaner Hefeweisse', 39, 6, 176724, 188385);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (24, 'Wine - Barbera Alba Doc 2001', 1, 1, 86538, 35087);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (25, 'Cheese - Brick With Pepper', 31, 8, 26398, 112292);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (26, 'Cocoa Powder - Dutched', 25, 7, 185182, 125649);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (27, 'Wine - Chardonnay Mondavi', 21, 1, 143844, 143434);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (28, 'Cheese - Cheddarsliced', 30, 5, 165599, 75712);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (29, 'Pail With Metal Handle 16l White', 21, 2, 166695, 170089);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (30, 'Coffee - Frthy Coffee Crisp', 40, 3, 182256, 196495);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (31, 'Creme De Menthe Green', 18, 6, 53345, 103159);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (32, 'Chicken - Leg, Fresh', 32, 6, 163334, 97929);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (33, 'Nestea - Ice Tea, Diet', 29, 6, 34492, 141616);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (34, 'Wine - Conde De Valdemar', 37, 2, 174720, 51443);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (35, 'Cheese - Goat', 24, 6, 60670, 138494);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (36, 'Ginsing - Fresh', 15, 3, 74429, 160091);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (37, 'Juice - Orange, 341 Ml', 25, 8, 65743, 31273);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (38, 'Juice - Clam, 46 Oz', 23, 3, 181652, 144152);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (39, 'Milk - 2%', 35, 2, 105514, 62910);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (40, 'Duck - Fat', 40, 8, 22633, 134574);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (41, 'French Kiss Vanilla', 11, 10, 99067, 19532);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (42, 'Veal - Heart', 9, 8, 17120, 74991);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (43, 'Cheese - Parmigiano Reggiano', 2, 2, 75877, 144507);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (44, 'Ocean Spray - Ruby Red', 9, 8, 49777, 27526);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (45, '7up Diet, 355 Ml', 17, 5, 37392, 158782);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (46, 'Tuna - Fresh', 9, 3, 152331, 43880);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (47, 'Cookie Dough - Peanut Butter', 21, 4, 13674, 130386);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (48, 'Parsley Italian - Fresh', 30, 4, 77775, 63102);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (49, 'Flower - Leather Leaf Fern', 11, 7, 195376, 70706);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (50, 'Cheese - La Sauvagine', 16, 2, 91999, 19007);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (51, 'Rootbeer', 40, 4, 26170, 40910);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (52, 'Sparkling Wine - Rose, Freixenet', 1, 1, 63723, 145113);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (53, 'Turkey - Breast, Double', 26, 4, 27900, 189405);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (54, 'Bread Base - Gold Formel', 37, 9, 97743, 57102);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (55, 'Pork - Caul Fat', 23, 1, 59949, 175306);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (56, 'Tarts Assorted', 18, 4, 85716, 106851);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (57, 'Whmis Spray Bottle Graduated', 29, 3, 192499, 24662);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (58, 'Jam - Strawberry, 20 Ml Jar', 19, 8, 166212, 26014);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (59, 'Lamb - Leg, Diced', 35, 8, 55811, 117278);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (60, 'Salad Dressing', 6, 7, 129485, 42509);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (61, 'Cookies - Englishbay Wht', 9, 5, 148718, 64378);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (62, 'Bread - Crumbs, Bulk', 8, 5, 181474, 67114);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (63, 'Bread - Corn Muffaleta Onion', 32, 4, 71445, 169875);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (64, 'Wine - Tio Pepe Sherry Fino', 18, 6, 117390, 67497);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (65, 'Wine - German Riesling', 29, 10, 199433, 34566);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (66, 'Potatoes - Instant, Mashed', 16, 1, 180754, 14915);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (67, 'Squid Ink', 7, 7, 31050, 46154);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (68, 'Muffin Mix - Oatmeal', 5, 4, 138216, 161647);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (69, 'Wine - Crozes Hermitage E.', 27, 1, 40669, 197588);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (70, 'Muffin Hinge Container 6', 35, 3, 162530, 151345);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (71, 'Glass Clear 8 Oz', 3, 2, 68375, 12414);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (72, 'Wine - Red, Concha Y Toro', 23, 2, 178295, 195077);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (73, 'Water - Green Tea Refresher', 9, 7, 13878, 97953);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (74, 'Chinese Foods - Chicken Wing', 1, 8, 120902, 156474);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (75, 'Sauce - Black Current, Dry Mix', 33, 4, 172616, 170560);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (76, 'Bar Nature Valley', 36, 8, 122044, 40497);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (77, 'Garbag Bags - Black', 32, 9, 91127, 128059);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (78, 'Yoplait - Strawbrasp Peac', 7, 3, 178707, 37548);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (79, 'Ecolab - Mikroklene 4/4 L', 5, 1, 67695, 166789);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (80, 'Flour - Pastry', 12, 1, 138855, 43927);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (81, 'Basil - Seedlings Cookstown', 28, 5, 125121, 20487);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (82, 'Salt - Celery', 31, 4, 79798, 114799);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (83, 'Rappini - Andy Boy', 34, 8, 58132, 27976);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (84, 'Jam - Raspberry,jar', 40, 6, 114771, 63143);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (85, 'Vermouth - Sweet, Cinzano', 13, 1, 89764, 96080);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (86, 'Muffin Hinge Container 6', 16, 8, 156257, 106242);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (87, 'Island Oasis - Wildberry', 38, 7, 90373, 46599);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (88, 'Appetiser - Bought', 11, 1, 83373, 175299);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (89, 'Cookie Dough - Oatmeal Rasin', 4, 1, 77573, 157836);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (90, 'Flour - Rye', 10, 8, 50294, 195778);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (91, 'Oil - Pumpkinseed', 29, 8, 189433, 98195);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (92, 'Juice - Pineapple, 48 Oz', 27, 8, 47543, 25513);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (93, 'Muffin Hinge Container 6', 29, 8, 138874, 128997);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (94, 'Brownies - Two Bite, Chocolate', 37, 6, 113697, 76292);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (95, 'Plastic Arrow Stir Stick', 37, 8, 124270, 144531);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (96, 'Carbonated Water - Raspberry', 32, 5, 179515, 184367);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (97, 'Cookie Dough - Peanut Butter', 32, 3, 192543, 83054);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (98, 'Fish - Base, Bouillion', 7, 1, 154117, 177640);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (99, 'Wine - Chateauneuf Du Pape', 1, 10, 192165, 142308);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (100, 'Bread - White, Sliced', 15, 5, 98098, 66665);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (101, 'Cut Wakame - Hanawakaba', 15, 8, 23945, 83980);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (102, 'Beef - Tender Tips', 2, 1, 154796, 26494);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (103, 'Appetizer - Escargot Puff', 14, 9, 192464, 14677);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (104, 'Ginger - Fresh', 19, 1, 171649, 12589);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (105, 'Wine - Cotes Du Rhone', 4, 7, 168155, 14777);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (106, 'Beans - Fava, Canned', 36, 6, 193456, 46866);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (107, 'Soup - Knorr, Ministrone', 2, 3, 131683, 103958);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (108, 'Pasta - Fett Alfredo, Single Serve', 27, 8, 73420, 184476);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (109, 'Chutney Sauce', 18, 5, 136304, 100024);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (110, 'Lettuce Romaine Chopped', 3, 8, 80476, 73304);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (111, 'Food Colouring - Green', 6, 3, 41436, 118586);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (112, 'Snapple Lemon Tea', 19, 5, 99369, 158808);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (113, 'Carbonated Water - Blackberry', 25, 8, 198235, 106614);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (114, 'Curry Paste - Green Masala', 15, 1, 47266, 58547);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (115, 'Pasta - Spaghetti, Dry', 25, 2, 183914, 89439);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (116, 'Cheese - Mozzarella', 16, 4, 50148, 193332);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (117, 'Raspberries - Fresh', 35, 9, 49549, 104072);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (118, 'Wine - Mondavi Coastal Private', 18, 1, 177391, 80287);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (119, 'Pants Custom Dry Clean', 36, 10, 178270, 191502);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (120, 'Wine - Blue Nun Qualitatswein', 22, 6, 125686, 54016);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (121, 'Oxtail - Cut', 2, 3, 195887, 126276);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (122, 'Parasol Pick Stir Stick', 40, 1, 43410, 188386);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (123, 'Tia Maria', 27, 4, 66609, 92201);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (124, 'Cheese - Romano, Grated', 5, 10, 116032, 176104);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (125, 'Tea - Herbal Sweet Dreams', 10, 10, 148353, 185610);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (126, 'Beer - True North Strong Ale', 36, 6, 106935, 66815);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (127, 'Beer - Guiness', 5, 6, 77091, 17412);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (128, 'Eggs - Extra Large', 4, 4, 60215, 146002);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (129, 'Sauce - Alfredo', 15, 7, 42012, 197678);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (130, 'English Muffin', 29, 3, 124217, 150140);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (131, 'Muskox - French Rack', 19, 5, 66706, 154149);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (132, 'Vinegar - Champagne', 34, 3, 31089, 24842);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (133, 'Lettuce - Escarole', 6, 4, 186684, 165907);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (134, 'Cake - Bande Of Fruit', 4, 5, 102516, 132941);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (135, 'Chinese Foods - Pepper Beef', 39, 1, 39508, 131589);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (136, 'Lettuce - Spring Mix', 19, 1, 71321, 144193);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (137, 'Cookies - Assorted', 4, 9, 84441, 61382);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (138, 'Wine - Rosso Del Veronese Igt', 7, 8, 186184, 156236);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (139, 'Sansho Powder', 20, 7, 69531, 21610);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (140, 'Bonito Flakes - Toku Katsuo', 34, 7, 151329, 55753);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (141, 'Beef - Short Loin', 35, 8, 30920, 198545);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (142, 'Soup - Tomato Mush. Florentine', 19, 6, 181544, 92574);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (143, 'Pork - Ground', 16, 5, 151113, 123987);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (144, 'Pastry - Apple Large', 16, 5, 129732, 156061);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (145, 'Catfish - Fillets', 22, 4, 76110, 73190);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (146, 'Remy Red Berry Infusion', 6, 7, 26653, 100857);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (147, 'Nacho Chips', 31, 6, 87758, 114383);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (148, 'Hagen Daza - Dk Choocolate', 37, 7, 96425, 139028);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (149, 'Pasta - Lasagna, Dry', 9, 4, 51940, 191224);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (150, 'Taro Root', 28, 1, 25906, 130815);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (151, 'Energy Drink Red Bull', 21, 2, 99435, 29086);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (152, 'Vodka - Smirnoff', 22, 10, 79046, 48297);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (153, 'Marjoram - Dried, Rubbed', 38, 7, 68800, 90206);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (154, 'Tofu - Firm', 13, 10, 52294, 94906);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (155, 'Pasta - Fusili Tri - Coloured', 25, 2, 124043, 96794);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (156, 'Foie Gras', 22, 10, 42312, 21035);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (157, 'Shrimp - Black Tiger 6 - 8', 36, 10, 172578, 94715);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (158, 'Cranberries - Fresh', 4, 5, 19794, 56425);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (159, 'Scallops - 10/20', 40, 6, 148753, 85318);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (160, 'Wine - Rhine Riesling Wolf Blass', 21, 9, 199422, 118770);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (161, 'Tart - Raisin And Pecan', 33, 9, 106503, 21935);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (162, 'Appetizer - Smoked Salmon / Dill', 39, 1, 162207, 64331);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (163, 'Juice - Clam, 46 Oz', 24, 4, 176728, 154787);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (164, 'Fond - Neutral', 29, 10, 117759, 122788);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (165, 'Vol Au Vents', 3, 1, 135280, 83448);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (166, 'Wine - Cave Springs Dry Riesling', 24, 6, 126425, 41767);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (167, 'Wine - Vidal Icewine Magnotta', 8, 10, 38601, 43926);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (168, 'Stock - Veal, Brown', 5, 5, 33398, 108284);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (169, 'Ecolab - Orange Frc, Cleaner', 23, 6, 93451, 179362);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (170, 'Onions - White', 34, 6, 199520, 117073);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (171, 'Steel Wool', 25, 9, 13640, 122980);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (172, 'Quail - Whole, Bone - In', 19, 5, 60718, 184149);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (173, 'Wine - Beringer Founders Estate', 5, 8, 198402, 25944);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (174, 'Beef - Tongue, Cooked', 7, 8, 159258, 109203);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (175, 'Coffee - Cafe Moreno', 1, 1, 68358, 162570);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (176, 'Bread - Rolls, Rye', 21, 4, 109235, 114334);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (177, 'Wine - Winzer Krems Gruner', 1, 5, 174645, 109726);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (178, 'Lettuce - Boston Bib - Organic', 6, 3, 49733, 81712);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (179, 'Bar Bran Honey Nut', 23, 2, 110422, 69893);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (180, 'Island Oasis - Lemonade', 8, 6, 135433, 14938);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (181, 'Wakami Seaweed', 39, 4, 116174, 49478);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (182, 'Wine - Chateau Aqueria Tavel', 1, 1, 158812, 91446);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (183, 'Cup - 3.5oz, Foam', 40, 8, 68978, 23774);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (184, 'Nut - Pumpkin Seeds', 27, 9, 124134, 90081);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (185, 'Juice - Apple Cider', 2, 4, 194360, 23036);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (186, 'Hickory Smoke, Liquid', 21, 5, 31521, 94087);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (187, 'Chicken - Livers', 3, 3, 69827, 191294);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (188, 'Eggplant - Asian', 14, 6, 58980, 21422);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (189, 'Napkin White', 34, 10, 134993, 29618);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (190, 'Cheese - Brie Roitelet', 20, 8, 79898, 126436);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (191, 'Wine - Valpolicella Masi', 7, 6, 132323, 96697);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (192, 'Fish - Halibut, Cold Smoked', 32, 1, 85431, 175867);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (193, 'Bulgar', 17, 8, 123280, 99790);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (194, 'Fish - Base, Bouillion', 10, 7, 155740, 148398);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (195, 'Plastic Wrap', 40, 4, 185922, 131139);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (196, 'Ecolab - Solid Fusion', 2, 10, 87932, 169681);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (197, 'Tart - Butter Plain Squares', 28, 6, 87464, 93945);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (198, 'Ham - Procutinni', 36, 10, 57500, 186515);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (199, 'Turkey - Breast, Double', 27, 10, 46584, 21372);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (200, 'Wine - Stoneliegh Sauvignon', 4, 9, 34593, 143509);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (201, 'Pasta - Lasagna Noodle, Frozen', 30, 8, 140141, 14646);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (202, 'Chocolate - Compound Coating', 5, 2, 162633, 64987);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (203, 'Nantucket - Pomegranate Pear', 19, 10, 28520, 67740);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (204, 'Tea - Green', 21, 4, 124402, 128433);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (205, 'Pork Loin Bine - In Frenched', 20, 6, 32203, 37398);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (206, 'Strawberries - California', 13, 3, 147995, 85712);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (207, 'Flavouring Vanilla Artificial', 37, 4, 158672, 56527);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (208, 'Shrimp - Black Tiger 8 - 12', 25, 3, 22740, 169409);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (209, 'Frangelico', 13, 1, 40900, 177781);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (210, 'Coffee - Colombian, Portioned', 12, 3, 178114, 199552);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (211, 'Pesto - Primerba, Paste', 22, 7, 109391, 29535);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (212, 'Tea - Decaf Lipton', 13, 6, 34056, 171085);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (213, 'Pasta - Rotini, Colour, Dry', 10, 6, 45791, 50483);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (214, 'Cheese - Le Cheve Noir', 34, 9, 188776, 24072);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (215, 'Longos - Cheese Tortellini', 7, 2, 18100, 91263);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (216, 'Wine - Puligny Montrachet A.', 2, 7, 64962, 90567);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (217, 'Chocolate - Liqueur Cups With Foil', 38, 2, 143254, 194710);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (218, 'Dried Peach', 16, 1, 128000, 24106);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (219, 'Pork - Sausage, Medium', 29, 10, 191091, 176871);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (220, 'Initation Crab Meat', 17, 4, 165573, 32949);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (221, 'Nectarines', 38, 10, 117628, 39913);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (222, 'Pop - Club Soda Can', 3, 5, 132834, 24033);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (223, 'French Pastries', 13, 7, 182232, 87025);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (224, 'Pastry - Apple Muffins - Mini', 19, 2, 118197, 83131);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (225, 'Truffle Paste', 5, 8, 18123, 21932);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (226, 'Sherry - Dry', 40, 9, 172867, 51196);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (227, 'Schnappes Peppermint - Walker', 24, 2, 186472, 146283);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (228, 'Shiratamako - Rice Flour', 36, 1, 61267, 12820);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (229, 'Ecolab - Medallion', 16, 1, 86149, 16555);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (230, 'Beef - Striploin', 39, 9, 102800, 71534);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (231, 'Table Cloth 54x72 Colour', 17, 9, 83837, 149211);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (232, 'Yokaline', 19, 3, 163346, 120571);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (233, 'Veal - Insides Provini', 35, 10, 61300, 190300);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (234, 'Zucchini - Green', 16, 10, 22897, 63574);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (235, 'Tomatoes - Cherry', 8, 8, 129118, 193791);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (236, 'Rhubarb', 16, 4, 142425, 30864);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (237, 'Cream - 35%', 39, 9, 181981, 174916);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (238, 'Pastry - Baked Cinnamon Stick', 15, 4, 138124, 116509);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (239, 'Swiss Chard', 29, 5, 86515, 48083);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (240, 'Sword Pick Asst', 7, 2, 39557, 140458);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (241, 'Beef - Flank Steak', 20, 3, 71983, 44519);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (242, 'Containter - 3oz Microwave Rect.', 32, 1, 130744, 71708);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (243, 'Bread - Multigrain', 1, 10, 161054, 73428);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (244, 'Cheese - Blue', 27, 3, 14156, 43715);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (245, 'Muffin Puck Ww Carrot', 15, 7, 103281, 72322);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (246, 'Beans - Black Bean, Canned', 2, 5, 81099, 159103);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (247, 'Ecolab - Solid Fusion', 9, 10, 13580, 44411);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (248, 'Garlic - Elephant', 1, 1, 59091, 26120);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (249, 'Nut - Pistachio, Shelled', 13, 8, 64872, 186838);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (250, 'Creme De Banane - Marie', 32, 7, 194201, 110606);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (251, 'Fudge - Cream Fudge', 28, 2, 182954, 172518);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (252, 'Soup - Campbells Bean Medley', 39, 4, 172880, 54512);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (253, 'Pork - Shoulder', 12, 9, 50389, 188713);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (254, 'Flower - Potmums', 26, 10, 48792, 13002);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (255, 'Shortbread - Cookie Crumbs', 36, 7, 93655, 123565);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (256, 'Chickhen - Chicken Phyllo', 20, 8, 119350, 45601);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (257, 'Ezy Change Mophandle', 31, 6, 136074, 83575);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (258, 'Hickory Smoke, Liquid', 39, 8, 106359, 53258);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (259, 'Puree - Guava', 16, 4, 195152, 120566);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (260, 'Pie Pecan', 31, 9, 42039, 52318);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (261, 'Water - San Pellegrino', 40, 5, 193162, 161438);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (262, 'Pork - Ground', 34, 9, 76298, 183450);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (263, 'Coffee - Ristretto Coffee Capsule', 17, 8, 194337, 132961);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (264, 'Nori Sea Weed', 32, 7, 32622, 151813);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (265, 'Lettuce - Baby Salad Greens', 2, 7, 155840, 35888);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (266, 'Fiddlehead - Frozen', 34, 4, 108129, 184363);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (267, 'Bread Fig And Almond', 18, 1, 64777, 107785);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (268, 'Sole - Dover, Whole, Fresh', 31, 2, 189027, 124788);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (269, 'Edible Flower - Mixed', 25, 6, 18650, 113868);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (270, 'Island Oasis - Sweet And Sour Mix', 25, 8, 52486, 117206);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (271, 'Chicken - Diced, Cooked', 20, 2, 20933, 108125);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (272, 'Ice Cream Bar - Rolo Cone', 25, 5, 188194, 143841);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (273, 'Chicken - Base', 10, 4, 167362, 177646);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (274, 'Paste - Black Olive', 16, 5, 167649, 23200);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (275, 'Flour - Strong Pizza', 11, 5, 138363, 109763);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (276, 'Bread - Sticks, Thin, Plain', 24, 2, 49170, 189497);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (277, 'Calypso - Pineapple Passion', 21, 7, 50634, 75376);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (278, 'Kiwi Gold Zespri', 18, 9, 111242, 40475);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (279, 'Liners - Banana, Paper', 19, 10, 62549, 26538);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (280, 'Lettuce - Boston Bib - Organic', 20, 10, 25850, 79531);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (281, 'Soup - Verve - Chipotle Chicken', 14, 2, 195085, 77403);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (282, 'Sambuca - Opal Nera', 22, 6, 77347, 195237);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (283, 'Sugar - Individual Portions', 17, 5, 20414, 88636);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (284, 'Shrimp - 16/20, Peeled Deviened', 11, 2, 67627, 144506);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (285, 'Foam Espresso Cup Plain White', 2, 4, 81094, 67284);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (286, 'Bamboo Shoots - Sliced', 14, 9, 104458, 195742);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (287, 'Alize Sunset', 10, 3, 78555, 27000);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (288, 'Spice - Peppercorn Melange', 20, 5, 74661, 29805);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (289, 'Bread - Italian Roll With Herbs', 5, 9, 89951, 71615);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (290, 'Muffin Orange Individual', 1, 9, 107032, 155066);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (291, 'Snails - Large Canned', 16, 3, 13076, 171090);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (292, 'Wine - Savigny - Les - Beaune', 26, 7, 102745, 98586);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (293, 'Bread - Italian Roll With Herbs', 14, 3, 52249, 30826);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (294, 'Grand Marnier', 3, 1, 18982, 114548);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (295, 'Coriander - Ground', 18, 6, 171248, 60762);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (296, 'Pie Shell - 5', 16, 10, 193616, 199860);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (297, 'Mousse - Passion Fruit', 30, 6, 53681, 142639);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (298, 'Spic And Span All Purpose', 22, 9, 39552, 90663);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (299, 'Grapefruit - White', 32, 10, 163944, 122890);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (300, 'Plasticspoonblack', 12, 4, 45603, 70480);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (301, 'Squid - Tubes / Tenticles 10/20', 21, 8, 182987, 40083);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (302, 'Lid - 0090 Clear', 35, 4, 37679, 169223);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (303, 'Soup - French Onion', 15, 1, 184709, 174297);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (304, 'Nougat - Paste / Cream', 14, 9, 20711, 164446);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (305, 'Cheese - Valancey', 14, 4, 88972, 83064);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (306, 'Nut - Pecan, Halves', 37, 10, 150083, 38067);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (307, 'Versatainer Nc - 8288', 17, 8, 71646, 41847);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (308, 'Straws - Cocktale', 14, 1, 130445, 179616);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (309, 'Squid U5 - Thailand', 16, 2, 132545, 98824);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (310, 'Veal - Loin', 28, 3, 173239, 19649);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (311, 'Mackerel Whole Fresh', 6, 9, 47366, 33632);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (312, 'Mayonnaise - Individual Pkg', 22, 3, 146890, 70955);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (313, 'Papayas', 27, 9, 119845, 153345);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (314, 'Cheese - Parmesan Grated', 18, 5, 56795, 164545);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (315, 'Wine - Trimbach Pinot Blanc', 39, 4, 170712, 99365);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (316, 'Kumquat', 9, 4, 12905, 191439);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (317, 'Pepperoni Slices', 4, 3, 191415, 28373);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (318, 'Beef - Outside, Round', 18, 6, 191151, 17829);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (319, 'Cactus Pads', 15, 6, 12524, 69850);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (320, 'Broccoli - Fresh', 14, 5, 111628, 171247);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (321, 'Tea - Herbal I Love Lemon', 26, 4, 168483, 57251);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (322, 'Yeast Dry - Fleischman', 20, 1, 175893, 115386);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (323, 'Broom - Angled', 39, 1, 195608, 36695);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (324, 'Basil - Seedlings Cookstown', 24, 2, 182964, 194307);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (325, 'Chocolate - Mi - Amere Semi', 23, 7, 198846, 74554);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (326, 'Crab - Soft Shell', 4, 2, 81360, 181615);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (327, 'Pineapple - Golden', 26, 6, 15070, 94098);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (328, 'Soup - Beef Conomme, Dry', 8, 3, 134238, 109211);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (329, 'Lettuce - Treviso', 28, 7, 137576, 17374);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (330, 'Pants Custom Dry Clean', 24, 4, 143909, 109759);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (331, 'Coconut - Shredded, Unsweet', 24, 10, 62973, 191101);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (332, 'Bread - Roll, Calabrese', 7, 7, 80032, 56613);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (333, 'Cake - Night And Day Choclate', 2, 9, 69623, 173951);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (334, 'Veal - Striploin', 39, 4, 129493, 102641);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (335, 'Puree - Kiwi', 35, 5, 99461, 81512);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (336, 'Kahlua', 22, 9, 150161, 98893);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (337, 'Bread - Multigrain', 4, 10, 157363, 22825);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (338, 'Wine - Touraine Azay - Le - Rideau', 12, 10, 161231, 174149);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (339, 'Cookie Choc', 14, 2, 99049, 115138);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (340, 'Garbage Bag - Clear', 16, 2, 25867, 83711);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (341, 'Flour - Whole Wheat', 35, 10, 73653, 102456);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (342, 'Oil - Olive Bertolli', 32, 8, 124023, 145177);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (343, 'Quail Eggs - Canned', 24, 7, 35840, 86917);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (344, 'Coffee - Flavoured', 27, 3, 63962, 99999);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (345, 'Energy Drink - Franks Original', 33, 1, 101638, 46881);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (346, 'Pizza Pizza Dough', 21, 7, 61315, 34201);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (347, 'Rye Special Old', 37, 4, 189676, 31906);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (348, 'Dill Weed - Fresh', 25, 8, 20610, 165272);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (349, 'Iced Tea - Lemon, 460 Ml', 27, 9, 156912, 42678);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (350, 'Coffee - Frthy Coffee Crisp', 14, 3, 69966, 89013);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (351, 'Tequila - Sauza Silver', 36, 2, 132672, 49839);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (352, 'Rhubarb', 35, 3, 113622, 140368);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (353, 'Orange - Blood', 11, 7, 72526, 17328);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (354, 'Lamb Shoulder Boneless Nz', 10, 10, 170483, 42426);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (355, 'Fond - Neutral', 14, 8, 120398, 139987);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (356, 'Cheese - Montery Jack', 18, 8, 31319, 95691);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (357, 'Bread - Crusty Italian Poly', 20, 3, 32080, 82546);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (358, 'Lychee', 4, 10, 162090, 89668);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (359, 'Yogurt - Strawberry, 175 Gr', 1, 9, 139862, 159060);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (360, 'The Pop Shoppe - Cream Soda', 25, 7, 121977, 116119);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (361, 'Cranberries - Dry', 12, 3, 90862, 114979);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (362, 'Crab - Dungeness, Whole', 35, 6, 197685, 11223);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (363, 'Pepper - Julienne, Frozen', 32, 5, 54314, 87428);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (364, 'Irish Cream - Baileys', 17, 10, 190857, 112160);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (365, 'Bulgar', 5, 5, 146219, 86143);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (366, 'Goat - Whole Cut', 19, 9, 99926, 26264);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (367, 'Soap - Hand Soap', 18, 9, 81557, 111947);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (368, 'Wine - Tio Pepe Sherry Fino', 24, 5, 170871, 97998);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (369, 'Salmon - Canned', 39, 7, 192927, 170509);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (370, 'Salt - Kosher', 22, 3, 151206, 90609);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (371, 'Beef Cheek Fresh', 11, 6, 133305, 51576);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (372, 'Ice Cream - Vanilla', 12, 6, 17852, 40559);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (373, 'Squash - Pattypan, Yellow', 40, 7, 176117, 197069);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (374, 'Sugar - Splenda Sweetener', 40, 9, 192288, 179058);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (375, 'Chicken - Livers', 33, 6, 129944, 124073);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (376, 'Bread - Rye', 10, 2, 159160, 132692);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (377, 'Cheese - Marble', 4, 2, 107644, 38126);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (378, 'Rabbit - Frozen', 27, 7, 94030, 53374);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (379, 'Bread - White, Sliced', 27, 5, 149528, 115469);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (380, 'Coconut - Creamed, Pure', 6, 3, 142881, 49563);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (381, 'Truffle Shells - White Chocolate', 27, 1, 81506, 13045);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (382, 'Devonshire Cream', 24, 10, 157393, 168258);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (383, 'Muffin Mix - Corn Harvest', 9, 9, 152726, 32203);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (384, 'Fenngreek Seed', 40, 8, 23719, 83633);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (385, 'Cheese - Parmesan Grated', 22, 8, 147900, 147458);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (386, 'Salami - Genova', 14, 4, 148113, 144491);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (387, 'Mace', 7, 6, 189507, 140282);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (388, 'Wine - Periguita Fonseca', 34, 2, 37325, 143498);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (389, 'Oil - Cooking Spray', 19, 5, 132310, 53427);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (390, 'Lamb - Leg, Boneless', 38, 3, 175025, 23932);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (391, 'Honey - Comb', 22, 9, 13827, 186182);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (392, 'Chick Peas - Dried', 25, 1, 66232, 97538);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (393, 'Sausage - Andouille', 31, 10, 28478, 154639);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (394, 'Beer - Sleeman Fine Porter', 30, 8, 40465, 117332);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (395, 'Oil - Olive Bertolli', 33, 6, 29464, 109157);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (396, 'Kirsch - Schloss', 35, 9, 92673, 12154);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (397, 'Wine - Redchard Merritt', 30, 5, 26600, 176143);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (398, 'Pastry - Banana Muffin - Mini', 29, 4, 153650, 48631);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (399, 'Muffin - Mix - Creme Brule 15l', 28, 8, 42525, 34261);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (400, 'Pork - Back, Long Cut, Boneless', 25, 3, 198964, 189764);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (401, 'Split Peas - Yellow, Dry', 19, 6, 184287, 194314);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (402, 'Cookies - Assorted', 19, 8, 57943, 84258);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (403, 'Lettuce - Frisee', 6, 6, 154537, 196966);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (404, 'Sauce - Roasted Red Pepper', 5, 9, 151927, 75701);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (405, 'Ham - Smoked, Bone - In', 14, 6, 102620, 47808);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (406, 'Campari', 4, 10, 64321, 172182);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (407, 'Beer - Blue Light', 15, 6, 198125, 91881);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (408, 'Bread - Assorted Rolls', 15, 10, 165234, 83875);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (409, 'Cod - Fillets', 8, 5, 91160, 100523);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (410, 'Fudge - Cream Fudge', 9, 5, 121470, 38815);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (411, 'Wine - Spumante Bambino White', 1, 3, 81425, 172278);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (412, 'Teriyaki Sauce', 38, 9, 147015, 98315);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (413, 'Soup - Campbellschix Stew', 35, 1, 70645, 19944);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (414, 'Salmon - Atlantic, Skin On', 10, 1, 133484, 71587);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (415, 'Milk - Chocolate 250 Ml', 22, 8, 176048, 151696);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (416, 'Mangoes', 23, 8, 89969, 98219);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (417, 'Monkfish - Fresh', 6, 7, 10007, 52046);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (418, 'Beans - Black Bean, Dry', 20, 8, 146346, 53321);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (419, 'Juice - Orange, Concentrate', 5, 4, 97541, 190817);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (420, 'Wine - White, Concha Y Toro', 11, 6, 154408, 159292);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (421, 'Wine - Chablis 2003 Champs', 16, 3, 170500, 186397);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (422, 'External Supplier', 29, 6, 38266, 158449);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (423, 'Chocolate Eclairs', 28, 9, 107106, 26683);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (424, 'Pork - Back, Short Cut, Boneless', 19, 9, 145778, 152492);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (425, 'Tamarillo', 39, 7, 192956, 61852);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (426, 'Steamers White', 31, 6, 139810, 40165);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (427, 'Veal - Inside Round / Top, Lean', 38, 3, 49951, 112091);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (428, 'Godiva White Chocolate', 22, 5, 45539, 35602);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (429, 'Tomato - Green', 14, 5, 110178, 144978);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (430, 'Nut - Pecan, Pieces', 14, 5, 149331, 194791);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (431, 'Saskatoon Berries - Frozen', 1, 9, 164922, 59251);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (432, 'Syrup - Monin, Swiss Choclate', 33, 2, 144207, 10865);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (433, 'Pork - Ham Hocks - Smoked', 29, 6, 142505, 32414);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (434, 'Tart Shells - Barquettes, Savory', 27, 1, 163000, 181374);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (435, 'Vinegar - Champagne', 27, 3, 35596, 20655);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (436, 'Wine - Cousino Macul Antiguas', 36, 7, 194763, 198365);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (437, 'Sobe - Lizard Fuel', 5, 2, 48814, 94600);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (438, 'Juice - Apple 284ml', 36, 10, 156179, 39535);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (439, 'Eggplant - Regular', 34, 8, 35158, 168666);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (440, 'Muffin Batt - Ban Dream Zero', 27, 3, 27209, 50682);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (441, 'Chicken - Whole Fryers', 20, 1, 180167, 111958);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (442, 'Veal - Osso Bucco', 11, 1, 52324, 40392);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (443, 'Tray - Foam, Square 4 - S', 7, 4, 11919, 167195);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (444, 'Sugar - Crumb', 11, 6, 193824, 88947);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (445, 'Lid - 16 Oz And 32 Oz', 31, 8, 190016, 96101);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (446, 'Leeks - Large', 25, 10, 55628, 109090);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (447, 'Beef - Top Butt', 27, 10, 108220, 168357);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (448, 'Lemon Tarts', 19, 10, 22571, 162390);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (449, 'Galliano', 20, 10, 154307, 171907);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (450, 'Flour - Masa De Harina Mexican', 25, 10, 114556, 55983);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (451, 'Smoked Tongue', 1, 3, 32060, 82880);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (452, 'French Kiss Vanilla', 4, 6, 127915, 67164);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (453, 'Compound - Pear', 19, 9, 83121, 22419);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (454, 'Wine - Taylors Reserve', 34, 10, 52219, 69612);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (455, 'Sterno - Chafing Dish Fuel', 33, 10, 30764, 32620);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (456, 'Cod - Fillets', 2, 7, 171538, 76486);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (457, 'Grapefruit - Pink', 5, 3, 170159, 155309);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (458, 'Truffle Cups Green', 16, 3, 107587, 147172);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (459, 'Bread - Corn Muffaleta Onion', 19, 1, 100663, 173231);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (460, 'Oven Mitts - 15 Inch', 7, 3, 166379, 100019);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (461, 'Beef - Shank', 40, 6, 129703, 38616);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (462, 'Canada Dry', 23, 7, 73644, 52438);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (463, 'Wine - White, Riesling, Semi - Dry', 2, 9, 46845, 112927);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (464, 'Celery', 26, 10, 168140, 180745);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (465, 'Scallops - In Shell', 9, 5, 115946, 84340);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (466, 'Cheese - Perron Cheddar', 37, 10, 157197, 89222);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (467, 'Crab - Blue, Frozen', 16, 8, 150015, 75778);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (468, 'Pepper Squash', 28, 4, 105803, 60063);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (469, 'Tamarillo', 23, 5, 186285, 67437);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (470, 'Leeks - Large', 38, 1, 198091, 196368);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (471, 'Crab - Soft Shell', 32, 3, 115080, 150794);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (472, 'Bread - Granary Small Pull', 38, 3, 165391, 101541);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (473, 'Wine - Rhine Riesling Wolf Blass', 23, 3, 103666, 59905);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (474, 'Wine - Malbec Trapiche Reserve', 2, 2, 107417, 114330);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (475, 'Wine - Fat Bastard Merlot', 30, 7, 123543, 47431);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (476, 'Towel Multifold', 6, 2, 97513, 188516);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (477, 'The Pop Shoppe - Grape', 16, 9, 63915, 175585);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (478, 'Soda Water - Club Soda, 355 Ml', 27, 7, 96975, 139703);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (479, 'Lobak', 28, 4, 160421, 63598);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (480, 'Soup V8 Roasted Red Pepper', 38, 8, 181279, 81030);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (481, 'Muffin Hinge - 211n', 8, 2, 131762, 58489);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (482, 'Cheese - Comte', 6, 7, 161429, 120969);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (483, 'Capers - Ox Eye Daisy', 18, 10, 115031, 121757);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (484, 'Peach - Fresh', 40, 10, 192618, 187257);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (485, 'Veal - Slab Bacon', 16, 10, 168407, 111112);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (486, 'Island Oasis - Mango Daiquiri', 16, 1, 95124, 136756);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (487, 'Wine - Pinot Noir Pond Haddock', 27, 5, 104413, 150695);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (488, 'Split Peas - Green, Dry', 29, 1, 95566, 93285);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (489, 'Flour - Whole Wheat', 24, 5, 107536, 170036);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (490, 'Soup - Cream Of Broccoli, Dry', 1, 2, 115052, 177426);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (491, 'Munchies Honey Sweet Trail Mix', 29, 10, 79212, 62868);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (492, 'Bols Melon Liqueur', 36, 6, 181990, 120245);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (493, 'Banana Turning', 30, 6, 100109, 195827);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (494, 'Soup - Tomato Mush. Florentine', 24, 4, 138039, 62556);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (495, 'Nut - Almond, Blanched, Ground', 13, 4, 109606, 36953);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (496, 'Lettuce - Curly Endive', 17, 10, 166853, 171865);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (497, 'Wine - Riesling Alsace Ac 2001', 18, 5, 199679, 97963);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (498, 'Peach - Fresh', 35, 3, 190499, 151743);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (499, 'Water - Tonic', 11, 3, 125979, 53596);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (500, 'Sauce - Black Current, Dry Mix', 40, 4, 50454, 70787);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (501, 'Paper - Brown Paper Mini Cups', 34, 3, 116591, 192236);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (502, 'Pie Shells 10', 28, 5, 81135, 72165);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (503, 'Nestea - Iced Tea', 17, 5, 72975, 114699);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (504, 'Asparagus - White, Fresh', 3, 6, 24688, 122540);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (505, 'Muffin - Blueberry Individual', 15, 2, 23572, 162795);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (506, 'Shrimp, Dried, Small / Lb', 10, 10, 49454, 17791);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (507, 'Tart Shells - Sweet, 2', 25, 6, 77901, 122043);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (508, 'Flavouring - Orange', 37, 6, 196769, 20008);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (509, 'Fish - Atlantic Salmon, Cold', 35, 10, 132732, 137445);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (510, 'Beef - Rib Eye Aaa', 2, 4, 86079, 113180);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (511, 'Bread - Raisin Walnut Pull', 8, 2, 39659, 181562);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (512, 'Beans - Navy, Dry', 38, 7, 135742, 122871);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (513, 'Beef - Tongue, Fresh', 35, 2, 73627, 86331);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (514, 'Trout Rainbow Whole', 33, 5, 183547, 85111);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (515, 'Chivas Regal - 12 Year Old', 29, 2, 54278, 72485);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (516, 'Glaze - Apricot', 11, 1, 52823, 160653);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (517, 'Table Cloth 81x81 White', 17, 3, 116187, 180554);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (518, 'Wine - Vineland Estate Semi - Dry', 16, 7, 70534, 12431);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (519, 'Bulgar', 36, 7, 169967, 77553);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (520, 'Soup - Campbells - Tomato', 26, 10, 144070, 27400);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (521, 'Sobe - Cranberry Grapefruit', 15, 5, 120364, 132495);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (522, 'Beef - Sushi Flat Iron Steak', 1, 5, 134241, 197006);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (523, 'Mushroom - Morels, Dry', 8, 9, 116323, 189769);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (524, 'Bread - Crusty Italian Poly', 34, 9, 115194, 24256);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (525, 'Muffin - Blueberry Individual', 16, 1, 102945, 197734);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (526, 'Sweet Pea Sprouts', 37, 6, 14707, 134728);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (527, 'Persimmons', 20, 7, 110671, 93435);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (528, 'Propel Sport Drink', 6, 2, 34677, 190374);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (529, 'Five Alive Citrus', 16, 8, 77439, 164508);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (530, 'Ecolab - Hobart Upr Prewash Arm', 40, 5, 135180, 144538);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (531, 'Extract - Lemon', 32, 7, 78002, 118186);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (532, 'Tomatoes - Hot House', 14, 4, 179415, 89387);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (533, 'Stainless Steel Cleaner Vision', 1, 7, 100829, 95820);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (534, 'Tart Shells - Savory, 3', 40, 8, 84125, 198206);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (535, 'Wine - Chardonnay Mondavi', 11, 8, 161072, 173879);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (536, 'Bread - Ciabatta Buns', 27, 7, 40998, 180288);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (537, 'Coffee - Frthy Coffee Crisp', 22, 1, 146822, 118568);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (538, 'Flour - Pastry', 30, 4, 23164, 88768);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (539, 'Sugar - White Packet', 30, 4, 125257, 156449);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (540, 'Lemonade - Island Tea, 591 Ml', 40, 8, 37080, 65216);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (541, 'Bread - Calabrese Baguette', 4, 10, 109873, 56710);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (542, 'Butcher Twine 4r', 33, 4, 12351, 145474);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (543, 'Kellogs Raisan Bran Bars', 13, 10, 83713, 182152);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (544, 'Wine - Saint Emilion Calvet', 23, 2, 152268, 30251);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (545, 'Wild Boar - Tenderloin', 19, 4, 143267, 154677);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (546, 'Wine - Manischewitz Concord', 23, 2, 13589, 82202);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (547, 'Wine - Semi Dry Riesling Vineland', 8, 2, 43823, 129285);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (548, 'Basil - Pesto Sauce', 33, 9, 184001, 94907);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (549, 'Red Pepper Paste', 35, 1, 58301, 66167);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (550, 'Tuna - Loin', 3, 5, 71424, 49237);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (551, 'Wine - Malbec Trapiche Reserve', 3, 2, 186259, 149997);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (552, 'Beef Cheek Fresh', 37, 3, 102396, 95297);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (553, 'Cheese Cheddar Processed', 13, 7, 130152, 180531);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (554, 'Oranges - Navel, 72', 29, 7, 174394, 187240);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (555, 'Wine - White, Cooking', 5, 7, 150582, 131875);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (556, 'Appetizer - Veg Assortment', 37, 10, 84920, 28733);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (557, 'Extract - Rum', 13, 10, 187884, 39998);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (558, 'Cheese - Brie,danish', 12, 9, 47031, 54293);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (559, 'Sweet Pea Sprouts', 19, 4, 60978, 153237);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (560, 'Beef - Shank', 32, 7, 63768, 187287);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (561, 'Sauce - Soy Low Sodium - 3.87l', 38, 9, 83100, 69793);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (562, 'Chips Potato All Dressed - 43g', 7, 4, 31188, 172349);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (563, 'Cake Circle, Foil, Scallop', 40, 6, 36643, 23247);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (564, 'Mop Head - Cotton, 24 Oz', 8, 2, 86742, 196775);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (565, 'Orange Roughy 4/6 Oz', 33, 10, 89928, 100760);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (566, 'Beer - Steamwhistle', 25, 10, 143179, 77333);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (567, 'Cornstarch', 13, 10, 118489, 66331);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (568, 'Lemonade - Natural, 591 Ml', 37, 9, 157983, 53525);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (569, 'Beef - Bones, Marrow', 32, 7, 11754, 67476);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (570, 'Pie Box - Cello Window 2.5', 33, 8, 188058, 120373);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (571, 'Cookie Trail Mix', 18, 4, 28065, 63576);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (572, 'Bread Base - Toscano', 32, 7, 60518, 121193);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (573, 'Seedlings - Clamshell', 31, 8, 34999, 91587);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (574, 'Pastry - Lemon Danish - Mini', 4, 5, 86347, 15634);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (575, 'Lotus Rootlets - Canned', 22, 9, 80626, 191753);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (576, 'Spice - Montreal Steak Spice', 3, 1, 25885, 30561);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (577, 'Napkin - Beverage 1 Ply', 33, 9, 22414, 65654);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (578, 'Crackers - Graham', 11, 6, 64534, 46775);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (579, 'Wooden Mop Handle', 39, 3, 10870, 70882);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (580, 'Flax Seed', 1, 2, 169356, 121738);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (581, 'Longos - Penne With Pesto', 6, 8, 151417, 136091);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (582, 'Ham Black Forest', 7, 9, 121991, 136488);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (583, 'Wine - Muscadet Sur Lie', 9, 7, 163415, 67319);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (584, 'Beef - Tenderloin Tails', 3, 4, 67723, 121063);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (585, 'Corn Syrup', 15, 5, 112729, 80753);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (586, 'Flour Pastry Super Fine', 29, 9, 67142, 56160);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (587, 'Spice - Onion Powder Granulated', 14, 1, 108961, 53648);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (588, 'Bread - 10 Grain Parisian', 5, 2, 103006, 45352);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (589, 'Wine - Jafflin Bourgongone', 20, 8, 69391, 35948);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (590, 'Kohlrabi', 36, 2, 18070, 67295);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (591, 'Soup Bowl Clear 8oz92008', 15, 1, 127065, 109364);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (592, 'Bread - Olive', 26, 8, 46402, 50816);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (593, 'Wine - Sake', 29, 8, 60403, 155544);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (594, 'Juice Peach Nectar', 26, 3, 134115, 79488);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (595, 'Buffalo - Tenderloin', 25, 3, 112866, 155315);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (596, 'White Baguette', 17, 1, 73288, 143766);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (597, 'Sugar - Brown', 7, 10, 128911, 160300);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (598, 'Grenadillo', 32, 3, 136221, 121994);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (599, 'Potatoes - Yukon Gold 5 Oz', 6, 5, 85048, 180004);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (600, 'Lettuce - Lambs Mash', 3, 3, 132949, 194269);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (601, 'Oil - Grapeseed Oil', 8, 9, 174774, 149544);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (602, 'Sobe - Berry Energy', 3, 3, 117324, 46818);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (603, 'Longos - Chicken Wings', 40, 8, 124824, 51964);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (604, 'Wine - Guy Sage Touraine', 30, 2, 123681, 189810);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (605, 'Vermacelli - Sprinkles, Assorted', 12, 1, 54806, 188490);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (606, 'Potatoes - Idaho 80 Count', 27, 7, 82948, 44644);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (607, 'Muffin Mix - Chocolate Chip', 13, 7, 54566, 116576);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (608, 'Longos - Chicken Curried', 4, 5, 144091, 24467);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (609, 'Cabbage - Green', 36, 1, 51491, 163584);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (610, 'Glass - Wine, Plastic, Clear 5 Oz', 25, 8, 61438, 155144);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (611, 'Juice Peach Nectar', 17, 6, 69792, 198989);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (612, 'Pork - Liver', 37, 5, 88978, 120901);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (613, 'Soup - Beef Conomme, Dry', 1, 10, 143030, 75553);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (614, 'Cookie Dough - Chocolate Chip', 20, 3, 189523, 100401);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (615, 'Chocolate - Feathers', 26, 2, 100807, 45516);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (616, 'Veal - Slab Bacon', 32, 6, 129206, 176541);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (617, 'Ham - Procutinni', 16, 9, 125874, 35049);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (618, 'Potatoes - Fingerling 4 Oz', 5, 5, 170318, 84811);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (619, 'Beer - Corona', 9, 5, 193091, 72296);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (620, 'Juice - Cranberry 284ml', 28, 4, 94835, 67460);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (621, 'Gatorade - Cool Blue Raspberry', 17, 4, 117740, 136392);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (622, 'Lamb Tenderloin Nz Fr', 38, 7, 113346, 27834);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (623, 'Beef - Flank Steak', 11, 4, 40774, 30695);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (624, 'Cheese - Stilton', 10, 9, 47297, 182777);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (625, 'Tomatoes - Hot House', 39, 2, 14491, 187267);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (626, 'Juice - Mango', 30, 6, 119793, 89898);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (627, 'Cheese - Montery Jack', 19, 7, 68605, 46033);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (628, 'Toamtoes 6x7 Select', 10, 8, 42633, 192854);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (629, 'Figs', 37, 4, 17002, 163257);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (630, 'Food Colouring - Orange', 40, 6, 77096, 148910);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (631, 'Dish Towel', 28, 9, 42599, 78731);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (632, 'Smirnoff Green Apple Twist', 6, 6, 128071, 189216);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (633, 'Wine - Sauvignon Blanc', 21, 9, 62762, 130680);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (634, 'Sauce - Black Current, Dry Mix', 2, 7, 129460, 194933);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (635, 'Beer - Alexander Kieths, Pale Ale', 40, 1, 116885, 117363);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (636, 'Butter - Unsalted', 25, 2, 16039, 63295);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (637, 'Pasta - Cappellini, Dry', 40, 6, 124926, 181138);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (638, 'Icecream - Dstk Strw Chseck', 34, 9, 145933, 144207);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (639, 'Carrots - Mini, Stem On', 19, 10, 89775, 16761);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (640, 'Wine - Delicato Merlot', 26, 6, 102368, 170437);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (641, 'Lamb - Leg, Boneless', 38, 8, 198728, 37168);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (642, 'Quail - Eggs, Fresh', 6, 5, 142514, 144513);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (643, 'Appetizer - Escargot Puff', 13, 7, 152129, 154500);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (644, 'Turkey - Breast, Boneless Sk On', 22, 10, 138499, 34651);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (645, 'Towel - Roll White', 4, 3, 108619, 175452);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (646, 'Orange Roughy 6/8 Oz', 35, 10, 86558, 87902);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (647, 'Flour - Pastry', 29, 2, 65505, 117768);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (648, 'Lobster - Live', 11, 8, 41239, 194125);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (649, 'Cake - Mini Cheesecake', 33, 10, 11137, 161758);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (650, 'Country Roll', 26, 7, 156998, 71103);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (651, 'Mushroom Morel Fresh', 38, 4, 133392, 66303);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (652, 'Pie Filling - Apple', 20, 1, 146612, 170613);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (653, 'Spring Roll Veg Mini', 35, 1, 156151, 86589);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (654, 'Croissant, Raw - Mini', 37, 3, 17416, 77568);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (655, 'Beer - Corona', 28, 6, 155157, 64943);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (656, 'Pasta - Gnocchi, Potato', 36, 1, 81367, 149152);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (657, 'Wine - Niagara,vqa Reisling', 7, 2, 72316, 34775);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (658, 'Sultanas', 35, 10, 47429, 158692);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (659, 'Soup - Verve - Chipotle Chicken', 18, 1, 50135, 20498);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (660, 'Pasta - Penne, Rigate, Dry', 34, 8, 144383, 115346);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (661, 'Tomato - Plum With Basil', 40, 1, 104888, 16458);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (662, 'Bread - Crumbs, Bulk', 8, 6, 73169, 157643);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (663, 'Appetizer - Smoked Salmon / Dill', 32, 8, 77784, 180944);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (664, 'Venison - Ground', 15, 2, 191705, 26645);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (665, 'Amarula Cream', 29, 6, 37491, 156999);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (666, 'Initation Crab Meat', 13, 9, 26975, 153022);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (667, 'Soup - Knorr, Chicken Gumbo', 2, 5, 191408, 117904);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (668, 'Pork - Bacon, Double Smoked', 32, 2, 27878, 96207);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (669, 'Butter Ripple - Phillips', 23, 2, 165808, 82562);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (670, 'Sugar - Fine', 18, 5, 155235, 194302);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (671, 'Pasta - Canelloni', 9, 3, 193908, 144156);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (672, 'Wine - Alicanca Vinho Verde', 19, 8, 159768, 143834);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (673, 'Cheese - Comtomme', 31, 3, 131488, 32943);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (674, 'Gatorade - Lemon Lime', 11, 4, 170920, 133652);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (675, 'Red Snapper - Fresh, Whole', 39, 4, 23742, 108386);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (676, 'Bread Bowl Plain', 15, 9, 76854, 12404);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (677, 'Soup Campbells Mexicali Tortilla', 40, 8, 126644, 148517);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (678, 'Tart Shells - Savory, 3', 26, 10, 83700, 55140);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (679, 'Vanilla Beans', 24, 6, 82519, 67075);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (680, 'Rice - Sushi', 3, 8, 139654, 100209);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (681, 'Sugar - Brown, Individual', 15, 1, 98550, 37081);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (682, 'Pepper - Jalapeno', 31, 5, 123160, 33829);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (683, 'Mussels - Cultivated', 7, 5, 121018, 34543);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (684, 'Frangelico', 14, 5, 57787, 139193);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (685, 'Beans - Kidney, Red Dry', 6, 7, 118366, 190519);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (686, 'Pasta - Gnocchi, Potato', 39, 10, 101919, 71683);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (687, 'Nut - Hazelnut, Ground, Natural', 30, 10, 149797, 43131);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (688, 'Puree - Blackcurrant', 37, 10, 182320, 49997);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (689, 'Steam Pan Full Lid', 40, 6, 41038, 39026);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (690, 'Cheese - Gorgonzola', 10, 9, 48570, 30576);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (691, 'Muffin Mix - Oatmeal', 6, 3, 161213, 80294);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (692, 'Sauce - Gravy, Au Jus, Mix', 19, 7, 70675, 155542);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (693, 'Appetizer - Mango Chevre', 34, 5, 21585, 84733);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (694, 'Swiss Chard - Red', 2, 2, 106211, 45761);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (695, 'Cheese - Cambozola', 17, 1, 116140, 135137);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (696, 'Soup - Campbells - Chicken Noodle', 17, 2, 84505, 12261);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (697, 'Cheese Cloth No 60', 31, 3, 114470, 51995);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (698, 'Pail - 4l White, With Handle', 39, 10, 136334, 165071);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (699, 'Beef - Rib Roast, Capless', 27, 4, 139190, 173399);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (700, 'Pork - Inside', 34, 2, 87685, 125491);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (701, 'Lid Coffeecup 12oz D9542b', 14, 7, 11458, 116959);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (702, 'Quiche Assorted', 24, 10, 53981, 128623);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (703, 'Silicone Parch. 16.3x24.3', 14, 9, 48759, 10053);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (704, 'Herb Du Provence - Primerba', 34, 3, 168367, 143736);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (705, 'Veal - Nuckle', 3, 5, 63222, 60582);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (706, 'Schnappes - Peach, Walkers', 29, 9, 83702, 57422);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (707, 'Soup - Cream Of Broccoli', 29, 6, 174476, 12040);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (708, 'Oil - Food, Lacquer Spray', 34, 4, 109160, 62672);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (709, 'Wine - White, Pelee Island', 10, 6, 164087, 98244);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (710, 'Bread - Pain Au Liat X12', 23, 5, 96900, 57332);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (711, 'Energy Drink - Franks Pineapple', 23, 9, 137028, 72819);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (712, 'Lettuce - Radicchio', 39, 2, 64116, 88689);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (713, 'Soup Bowl Clear 8oz92008', 37, 5, 99531, 95596);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (714, 'Cream - 18%', 36, 7, 105602, 166147);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (715, 'Chivas Regal - 12 Year Old', 21, 10, 17679, 47715);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (716, 'Bols Melon Liqueur', 33, 2, 153073, 19107);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (717, 'Clams - Bay', 34, 8, 107732, 18945);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (718, 'Scotch - Queen Anne', 39, 4, 10639, 126370);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (719, 'Glove - Cutting', 24, 4, 149260, 13407);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (720, 'Wine - Bouchard La Vignee Pinot', 40, 5, 199186, 65041);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (721, 'Macaroons - Two Bite Choc', 3, 3, 117168, 52884);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (722, 'Juice Peach Nectar', 6, 6, 195049, 91609);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (723, 'Arizona - Green Tea', 13, 10, 167082, 59752);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (724, 'Yokaline', 11, 3, 153356, 97509);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (725, 'Plate - Foam, Bread And Butter', 26, 7, 109205, 159014);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (726, 'Apron', 36, 2, 174182, 70023);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (727, 'Wine - Sake', 10, 8, 87330, 47759);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (728, 'Oyster - In Shell', 11, 7, 38291, 155059);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (729, 'Pasta - Agnolotti - Butternut', 15, 4, 113722, 81113);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (730, 'Wine - Coteaux Du Tricastin Ac', 40, 10, 128377, 51861);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (731, 'Cherries - Maraschino,jar', 3, 1, 136236, 112672);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (732, 'Wine - Valpolicella Masi', 30, 3, 25875, 151148);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (733, 'Kellogs Cereal In A Cup', 1, 2, 80690, 61823);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (734, 'Chocolate - Semi Sweet', 8, 9, 38978, 47117);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (735, 'Chestnuts - Whole,canned', 10, 4, 177228, 173421);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (736, 'Rice - Wild', 38, 6, 175452, 142208);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (737, 'Soap - Hand Soap', 25, 3, 133149, 125625);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (738, 'Pie Shells 10', 15, 10, 154198, 159100);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (739, 'Milkettes - 2%', 15, 10, 17426, 33283);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (740, 'Taro Leaves', 37, 3, 182714, 184348);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (741, 'Quail Eggs - Canned', 5, 8, 13764, 48350);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (742, 'Cup - 6oz, Foam', 32, 5, 91033, 27647);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (743, 'Croissants Thaw And Serve', 5, 8, 138348, 130560);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (744, 'Pail For Lid 1537', 18, 2, 12515, 184626);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (745, 'Beef - Tongue, Cooked', 21, 6, 32791, 112505);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (746, 'Beer - Original Organic Lager', 24, 2, 85948, 112793);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (747, 'Aspic - Amber', 28, 5, 97820, 178160);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (748, 'Cleaner - Comet', 12, 10, 84449, 74616);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (749, 'Mustard - Seed', 1, 7, 89767, 137741);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (750, 'Godiva White Chocolate', 23, 1, 110438, 33568);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (751, 'Wine - Crozes Hermitage E.', 17, 4, 109778, 28348);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (752, 'Longos - Greek Salad', 18, 10, 99674, 26538);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (753, 'Canadian Emmenthal', 8, 10, 48286, 43783);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (754, 'Ice Cream Bar - Oreo Cone', 17, 6, 93285, 49074);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (755, 'Wine - Balbach Riverside', 10, 2, 53894, 13976);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (756, 'Salmon Steak - Cohoe 6 Oz', 8, 4, 191210, 22497);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (757, 'Monkfish Fresh - Skin Off', 16, 1, 102384, 95416);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (758, 'Five Alive Citrus', 21, 7, 63202, 144669);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (759, 'Pickles - Gherkins', 29, 8, 34092, 123646);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (760, 'Chocolate Bar - Coffee Crisp', 31, 6, 115914, 21712);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (761, 'Nori Sea Weed - Gold Label', 8, 3, 110530, 179280);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (762, 'Clam - Cherrystone', 30, 3, 83727, 80027);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (763, 'Venison - Denver Leg Boneless', 11, 7, 104566, 149002);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (764, 'Quiche Assorted', 25, 3, 49238, 78660);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (765, 'Turkey - Breast, Boneless Sk On', 11, 1, 63209, 131239);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (766, 'Beef - Kobe Striploin', 31, 9, 70167, 30106);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (767, 'Samosa - Veg', 34, 5, 142320, 109208);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (768, 'Cheese - Swiss', 22, 10, 175267, 75861);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (769, 'Nut - Pumpkin Seeds', 39, 8, 172543, 99845);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (770, 'Butter - Salted', 2, 4, 12488, 11958);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (771, 'Flour - Bread', 3, 2, 195479, 167155);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (772, 'Pasta - Lasagna Noodle, Frozen', 15, 5, 64182, 127745);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (773, 'Wine - Ej Gallo Sonoma', 33, 2, 103271, 39864);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (774, 'Pork - Suckling Pig', 36, 7, 193260, 93019);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (775, 'Wine - Valpolicella Masi', 17, 9, 157459, 78252);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (776, 'Eggwhite Frozen', 1, 3, 76109, 103106);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (777, 'Sole - Iqf', 29, 5, 118482, 197913);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (778, 'Juice - Cranberry, 341 Ml', 29, 3, 161926, 16077);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (779, 'Wine - White, Schroder And Schyl', 26, 9, 174266, 61100);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (780, 'Amaretto', 20, 5, 12759, 120291);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (781, 'Bread - Sour Sticks With Onion', 39, 9, 141495, 183791);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (782, 'Bread - Dark Rye', 16, 10, 101180, 17146);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (783, 'Cream Of Tartar', 9, 8, 151684, 118400);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (784, 'Carrots - Mini, Stem On', 4, 3, 162905, 140168);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (785, 'Pimento - Canned', 11, 6, 132109, 194978);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (786, 'Cheese - Blue', 6, 1, 46099, 56942);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (787, 'Lentils - Green, Dry', 23, 9, 79213, 37527);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (788, 'Cheese - Cambozola', 36, 7, 28804, 155372);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (789, 'Olives - Green, Pitted', 13, 5, 99967, 35250);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (790, 'Nestea - Ice Tea, Diet', 23, 9, 52713, 37527);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (791, 'Lettuce - Lolla Rosa', 25, 7, 186006, 174354);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (792, 'Lettuce - Green Leaf', 17, 2, 43850, 46667);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (793, 'Sage - Ground', 17, 7, 149687, 106560);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (794, 'Tea - Decaf Lipton', 33, 9, 90628, 30513);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (795, 'Quail - Eggs, Fresh', 37, 3, 120261, 194055);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (796, 'Soup - Campbells Beef Strogonoff', 20, 8, 86524, 173417);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (797, 'Rum - Cream, Amarula', 14, 8, 27244, 122406);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (798, 'Fish - Artic Char, Cold Smoked', 40, 6, 24344, 161014);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (799, 'Pear - Asian', 15, 10, 198492, 135269);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (800, 'Pasta - Linguini, Dry', 35, 10, 115149, 54399);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (801, 'Cheese - Goat With Herbs', 35, 10, 134166, 92184);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (802, 'Pasta - Fusili, Dry', 13, 10, 43240, 89694);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (803, 'Trout - Rainbow, Frozen', 37, 4, 88043, 196010);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (804, 'Chinese Foods - Plain Fried Rice', 29, 6, 85128, 66846);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (805, 'Island Oasis - Pina Colada', 40, 1, 119039, 142229);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (806, 'Seedlings - Buckwheat, Organic', 12, 8, 142076, 187413);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (807, 'Wine - Chablis 2003 Champs', 23, 6, 33552, 37065);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (808, 'Wine - Sake', 5, 4, 133815, 33536);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (809, 'Tofu - Firm', 17, 5, 90476, 54635);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (810, 'Sauce - Gravy, Au Jus, Mix', 20, 1, 94695, 108342);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (811, 'Bread Country Roll', 27, 4, 162023, 17223);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (812, 'Milk 2% 500 Ml', 27, 4, 142745, 87380);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (813, 'Chinese Foods - Plain Fried Rice', 40, 8, 181178, 15395);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (814, 'Wild Boar - Tenderloin', 1, 5, 43311, 171404);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (815, 'Kippers - Smoked', 40, 3, 169842, 41783);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (816, 'Wine - Baron De Rothschild', 1, 9, 58077, 49594);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (817, 'Lychee - Canned', 28, 5, 23104, 13899);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (818, 'Dry Ice', 39, 1, 96457, 44767);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (819, 'Pepper - Cayenne', 11, 2, 68123, 48806);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (820, 'Spice - Paprika', 26, 8, 68197, 178818);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (821, 'Oil - Safflower', 9, 9, 48823, 81128);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (822, 'Gatorade - Lemon Lime', 13, 7, 25662, 34698);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (823, 'Cherries - Frozen', 32, 1, 93035, 141378);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (824, 'Coffee - Beans, Whole', 3, 7, 172517, 103053);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (825, 'Chocolate Liqueur - Godet White', 8, 7, 115360, 176530);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (826, 'Easy Off Oven Cleaner', 27, 1, 30689, 159734);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (827, 'Table Cloth 72x144 White', 35, 1, 49915, 195524);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (828, 'Cleaner - Bleach', 37, 1, 86584, 102155);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (829, 'Venison - Denver Leg Boneless', 28, 8, 162793, 192621);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (830, 'Mix - Cocktail Ice Cream', 13, 8, 191015, 124743);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (831, 'Meldea Green Tea Liquor', 12, 1, 184929, 40810);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (832, 'Fond - Neutral', 4, 4, 93540, 123609);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (833, 'Beef - Bresaola', 34, 5, 78676, 88378);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (834, 'Napkin - Dinner, White', 14, 6, 16261, 48559);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (835, 'Shrimp - 16 - 20 Cooked, Peeled', 28, 1, 74928, 10976);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (836, 'Pomello', 34, 3, 194661, 43579);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (837, 'Soupfoamcont12oz 112con', 22, 4, 149280, 21657);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (838, 'Muffin Puck Ww Carrot', 20, 9, 185755, 189438);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (839, 'Mushroom - Morel Frozen', 7, 4, 16035, 148913);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (840, 'Mushroom - Lg - Cello', 23, 6, 124649, 36063);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (841, 'Broom - Angled', 34, 2, 35834, 139792);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (842, 'Tea - Decaf Lipton', 25, 2, 45513, 74207);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (843, 'Kiwi Gold Zespri', 20, 8, 192641, 72250);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (844, 'Wine - Ice Wine', 30, 8, 14006, 134196);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (845, 'Lettuce - Radicchio', 35, 9, 166703, 119033);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (846, 'Cheese - Roquefort Pappillon', 13, 3, 65895, 157586);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (847, 'Doilies - 10, Paper', 33, 8, 78098, 114216);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (848, 'Turkey Leg With Drum And Thigh', 4, 5, 140570, 70717);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (849, 'Piping - Bags Quizna', 2, 3, 94538, 173595);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (850, 'Pastry - Carrot Muffin - Mini', 23, 5, 98815, 22228);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (851, 'Cinnamon Rolls', 15, 7, 161389, 159589);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (852, 'Lettuce - Romaine, Heart', 20, 6, 101644, 88874);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (853, 'Rabbit - Whole', 23, 9, 47340, 120133);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (854, 'Longos - Grilled Veg Sandwiches', 1, 7, 83838, 41832);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (855, 'Lemon Balm - Fresh', 24, 6, 46585, 99065);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (856, 'Bread - Malt', 5, 10, 36176, 88910);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (857, 'Venison - Ground', 22, 3, 52816, 54530);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (858, 'Pie Filling - Apple', 10, 10, 130408, 80758);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (859, 'The Pop Shoppe - Black Cherry', 38, 10, 103596, 143227);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (860, 'Soup - Cream Of Broccoli, Dry', 27, 9, 107869, 198286);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (861, 'Syrup - Monin, Amaretta', 35, 3, 26589, 47020);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (862, 'Muffin Batt - Choc Chk', 40, 8, 159079, 45058);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (863, 'Muffin Mix - Carrot', 24, 4, 25663, 182584);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (864, 'Bread - White Epi Baguette', 20, 9, 104242, 51157);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (865, 'Mushroom - Trumpet, Dry', 26, 8, 76684, 102972);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (866, 'Cheese - St. Andre', 37, 5, 70879, 82823);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (867, 'Halibut - Steaks', 35, 3, 82598, 195336);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (868, 'Wine - Niagara Peninsula Vqa', 40, 8, 144856, 154291);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (869, 'Soup - Base Broth Chix', 6, 8, 146510, 111069);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (870, 'Bread - Raisin', 25, 8, 180422, 73316);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (871, 'Bread - Multigrain', 21, 9, 113664, 108422);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (872, 'Cheese - La Sauvagine', 9, 2, 191902, 101694);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (873, 'Pork Casing', 11, 3, 104298, 50177);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (874, 'Pork - Shoulder', 26, 8, 84162, 26624);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (875, 'Oranges - Navel, 72', 26, 4, 100021, 126312);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (876, 'Table Cloth 72x144 White', 18, 2, 183261, 191415);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (877, 'Beer - Fruli', 31, 10, 167939, 123148);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (878, 'Instant Coffee', 2, 7, 43097, 77385);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (879, 'Cheese - Gorgonzola', 18, 1, 67424, 93013);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (880, 'Wine - Jafflin Bourgongone', 14, 9, 49950, 189494);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (881, 'Wine - Taylors Reserve', 7, 3, 70908, 157923);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (882, 'Grenadillo', 35, 10, 51871, 166282);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (883, 'Cabbage - Nappa', 34, 10, 155490, 100323);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (884, 'Wine - Lou Black Shiraz', 36, 4, 85902, 45488);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (885, 'Bar - Granola Trail Mix Fruit Nut', 27, 7, 167017, 51251);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (886, 'Cheese - Montery Jack', 28, 10, 155013, 60574);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (887, 'Icecream Bar - Del Monte', 12, 1, 91824, 90699);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (888, 'Oil - Grapeseed Oil', 26, 4, 43745, 164062);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (889, 'Fiddlehead - Frozen', 18, 5, 86884, 41877);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (890, 'Fish - Scallops, Cold Smoked', 37, 1, 160422, 81506);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (891, 'Tamarind Paste', 35, 6, 50809, 88656);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (892, 'Food Colouring - Orange', 21, 6, 38204, 11174);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (893, 'Nut - Walnut, Chopped', 20, 3, 80277, 23929);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (894, 'Wine - Saint - Bris 2002, Sauv', 13, 5, 99472, 69072);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (895, 'Vanilla Beans', 15, 7, 22143, 64499);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (896, 'Wine - Lou Black Shiraz', 37, 2, 177832, 74453);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (897, 'The Pop Shoppe - Grape', 14, 4, 27048, 102560);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (898, 'Wine - Muscadet Sur Lie', 25, 5, 47273, 125938);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (899, 'Wine - Fontanafredda Barolo', 15, 2, 12737, 128704);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (900, 'Juice - Pineapple, 341 Ml', 17, 10, 151357, 40460);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (901, 'Chicken - Whole', 34, 4, 163797, 45024);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (902, 'Vinegar - Sherry', 14, 7, 181053, 138107);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (903, 'Egg Patty Fried', 6, 9, 66267, 153227);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (904, 'Dry Ice', 14, 5, 126963, 103085);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (905, 'Oil - Sesame', 30, 3, 43467, 139748);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (906, 'Tuna - Fresh', 6, 5, 98697, 59581);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (907, 'Port - 74 Brights', 25, 7, 109504, 141460);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (908, 'Bar Energy Chocchip', 35, 4, 51714, 119683);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (909, 'Pork - Ham, Virginia', 30, 3, 28308, 198154);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (910, 'Bread - Raisin Walnut Pull', 19, 3, 108917, 108390);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (911, 'Pork - Suckling Pig', 40, 9, 92096, 65931);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (912, 'Aspic - Light', 31, 6, 132413, 81654);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (913, 'Sproutsmustard Cress', 17, 3, 183137, 13280);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (914, 'Swordfish Loin Portions', 22, 5, 143856, 137563);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (915, 'Eggplant Italian', 21, 1, 48023, 130868);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (916, 'Pasta - Orzo, Dry', 12, 6, 120040, 164180);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (917, 'Wine - Redchard Merritt', 38, 5, 122693, 35788);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (918, 'Blouse / Shirt / Sweater', 11, 4, 185696, 147622);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (919, 'Butter Sweet', 35, 7, 16016, 180229);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (920, 'Prunes - Pitted', 29, 3, 125864, 71931);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (921, 'Tray - 12in Rnd Blk', 11, 1, 40388, 15279);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (922, 'Crab - Blue, Frozen', 14, 9, 37906, 90641);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (923, 'Hot Choc Vending', 5, 9, 21471, 195221);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (924, 'Pectin', 7, 10, 104924, 173648);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (925, 'Bread - Roll, Calabrese', 26, 8, 138510, 195777);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (926, 'Coffee - Dark Roast', 27, 3, 85429, 178393);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (927, 'Bagels Poppyseed', 4, 4, 192074, 106766);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (928, 'Cheese - Montery Jack', 31, 6, 185323, 131075);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (929, 'Sugar - Brown, Individual', 33, 1, 67324, 108771);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (930, 'Pepper - White, Ground', 5, 9, 74473, 53246);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (931, 'Crush - Grape, 355 Ml', 3, 9, 191613, 136276);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (932, 'Spaghetti Squash', 2, 1, 183429, 80967);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (933, 'Saskatoon Berries - Frozen', 7, 3, 131906, 99359);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (934, 'Sobe - Green Tea', 17, 10, 151345, 40444);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (935, 'Wine - Sicilia Igt Nero Avola', 36, 5, 105631, 198488);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (936, 'Bread Cranberry Foccacia', 31, 2, 198672, 126063);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (937, 'Chilli Paste, Sambal Oelek', 27, 7, 17272, 131425);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (938, 'Salmon - Whole, 4 - 6 Pounds', 11, 6, 64923, 17521);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (939, 'Soup - Knorr, Ministrone', 17, 6, 52483, 89073);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (940, 'Shrimp - 16/20, Iqf, Shell On', 17, 4, 197390, 49948);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (941, 'Beef - Tenderloin', 2, 1, 53244, 167688);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (942, 'Beer - Corona', 5, 9, 28385, 24223);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (943, 'Flower - Daisies', 29, 5, 66271, 144037);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (944, 'Clam Nectar', 28, 2, 112576, 31467);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (945, 'The Pop Shoppe - Black Cherry', 36, 7, 116605, 114298);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (946, 'Wine - Red, Concha Y Toro', 13, 1, 142340, 38156);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (947, 'Fish - Halibut, Cold Smoked', 16, 8, 115235, 129310);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (948, 'Boogies', 14, 5, 92223, 120056);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (949, 'Chickensplit Half', 5, 3, 94926, 120092);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (950, 'Cabbage - Green', 34, 5, 72011, 91298);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (951, 'Red Currant Jelly', 20, 5, 64092, 198504);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (952, 'Tea - Honey Green Tea', 3, 5, 50755, 175878);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (953, 'Bread - Corn Muffaletta', 25, 9, 61410, 150806);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (954, 'Goldschalger', 19, 3, 36757, 63196);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (955, 'Canadian Emmenthal', 7, 8, 36241, 51459);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (956, 'Fireball Whisky', 22, 2, 112314, 167590);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (957, 'Bread - Pita', 17, 1, 191444, 42915);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (958, 'Cheese - Cheddar, Old White', 33, 10, 137024, 57181);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (959, 'Aspic - Amber', 8, 9, 14442, 121518);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (960, 'Kolrabi', 19, 7, 124787, 31484);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (961, 'Bacardi Mojito', 21, 6, 85676, 95335);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (962, 'Table Cloth 120 Round White', 20, 10, 179532, 156991);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (963, 'Sunflower Seed Raw', 5, 8, 118465, 19224);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (964, 'Nantucket Pine Orangebanana', 28, 4, 27619, 149533);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (965, 'Appetizer - Mango Chevre', 3, 5, 116450, 92689);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (966, 'Pepper - Chipotle, Canned', 33, 10, 73229, 169986);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (967, 'Crackers Cheez It', 13, 7, 68876, 111342);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (968, 'Sour Puss - Tangerine', 6, 6, 136232, 101052);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (969, 'Tea - Lemon Scented', 39, 5, 30713, 128109);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (970, 'Smoked Tongue', 29, 2, 34957, 39450);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (971, 'Mushrooms - Black, Dried', 32, 10, 87506, 137220);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (972, 'Edible Flower - Mixed', 31, 8, 89326, 183879);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (973, 'Fish - Artic Char, Cold Smoked', 27, 10, 156971, 154678);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (974, 'Rambutan', 14, 7, 74310, 107620);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (975, 'Cabbage Roll', 15, 4, 45215, 16601);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (976, 'Juice - V8, Tomato', 33, 8, 59642, 127585);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (977, 'Venison - Denver Leg Boneless', 25, 5, 31671, 186352);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (978, 'Spinach - Baby', 18, 1, 170839, 144265);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (979, 'Cattail Hearts', 13, 5, 184239, 11025);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (980, 'Kale - Red', 30, 5, 100689, 82173);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (981, 'Lemon Balm - Fresh', 25, 3, 145194, 51836);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (982, 'Hold Up Tool Storage Rack', 34, 7, 157765, 72301);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (983, 'Icecream - Dstk Cml And Fdg', 3, 6, 130304, 181411);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (984, 'Vacuum Bags 12x16', 32, 5, 101511, 71661);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (985, 'Chocolate - Sugar Free Semi Choc', 15, 6, 160819, 127713);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (986, 'Glaze - Apricot', 34, 4, 45348, 172741);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (987, 'Bandage - Flexible Neon', 31, 3, 100625, 176533);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (988, 'Turkey - Breast, Double', 39, 3, 46910, 122032);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (989, 'Pecan Raisin - Tarts', 23, 10, 74611, 71645);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (990, 'Wine - White, Pinot Grigio', 5, 10, 99352, 172950);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (991, 'Jolt Cola', 28, 5, 53380, 88607);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (992, 'Carbonated Water - Cherry', 39, 3, 13356, 136241);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (993, 'Pastry - Choclate Baked', 33, 1, 22005, 176988);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (994, 'Jam - Raspberry', 21, 7, 35175, 174099);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (995, 'Plate Pie Foil', 2, 9, 28453, 57450);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (996, 'Higashimaru Usukuchi Soy', 33, 4, 89006, 88605);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (997, 'Gingerale - Diet - Schweppes', 13, 8, 43733, 46903);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (998, 'Onions - Pearl', 27, 7, 38500, 182166);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (999, 'Crackers - Graham', 26, 9, 47241, 144930);
insert into products (pid, productname, sid, categoryid, costPrice, sellingPrice) values (1000, 'Wine - Tio Pepe Sherry Fino', 34, 2, 170538, 158155);

--
INSERT INTO customers (citizenIDNumber, gender, fullname, location, birthDate, phone, EMAIL) VALUES
('123456789', 1, 'Nguyen Van A', 'Ha Noi', '1990-01-01', '0987654321', 'nguyenvana@gmail.com'),
('987654321', 0, 'Tran Thi B', 'Ho Chi Minh City', '1985-05-15', '0912345678', 'tranthib@gmail.com'),
('246801357', 1, 'Le Van C', 'Da Nang', '1995-11-25', '0909090909', 'levanc@gmail.com'),
('135790864', 0, 'Pham Thi D', 'Hai Phong', '1993-03-03', '0977777777', 'phamthid@gmail.com'),
('864197530', 1, 'Vo Van E', 'Can Tho', '1991-09-09', '0966666666', 'vovane@gmail.com'),
('975318642', 0, 'Hoang Thi F', 'Nha Trang', '1992-12-12', '0933333333', 'hoangthif@gmail.com'),
('753186429', 1, 'Truong Van G', 'Hue', '1994-07-07', '0944444444', 'truongvang@gmail.com'),
('357924680', 0, 'Bui Thi H', 'Vung Tau', '1996-02-02', '0988888888', 'buithih@gmail.com'),
('624135870', 1, 'Dinh Van I', 'Quy Nhon', '1998-04-04', '0969696969', 'dinhvani@gmail.com'),
('581246930', 0, 'Do Thi K', 'Phu Quoc', '1989-08-08', '0911111111', 'dothik@gmail.com'),
('975310246', 1, 'Tran Van L', 'Bien Hoa', '1997-06-06', '0906060606', 'tranvanl@gmail.com'),
('135792468', 0, 'Nguyen Thi M', 'Long Xuyen', '1999-10-10', '0979797979', 'nguyenthim@gmail.com'),
('246801357', 1, 'Le Van N', 'Ha Tinh', '1993-01-31', '0918181818', 'levann@gmail.com'),
('864197530', 0, 'Pham Van O', 'Sai Gon', '1994-02-28', '0969696969', 'phamvano@gmail.com'),
('123456789', 1, 'Nguyen Van A', 'Ha Noi', '1990-01-01', '0987654321', 'nguyenvana@gmail.com'),
('987654321', 0, 'Tran Thi B', 'Ho Chi Minh City', '1985-05-15', '0912345678', 'tranthib@gmail.com'),
('456789123', 1, 'Le Thi C', 'Da Nang', '1995-03-10', '0961234567', 'lethic@gmail.com'),
('789123456', 0, 'Pham Van D', 'Hai Phong', '1982-12-25', '0977654321', 'phamvand@gmail.com'),
('321654987', 1, 'Tran Van E', 'Nha Trang', '1998-08-08', '0934567890', 'tranvane@gmail.com'),
('654987321', 0, 'Nguyen Thi F', 'Can Tho', '1992-06-30', '0965432109', 'nguyenthif@gmail.com'),
('987321654', 1, 'Le Van G', 'Da Lat', '1989-11-11', '0988888888', 'levang@gmail.com'),
('123789456', 0, 'Nguyen Van H', 'Vung Tau', '1987-07-07', '0909090909', 'nguyenvanh@gmail.com'),
('456123789', 1, 'Tran Thi I', 'Hue', '1996-04-20', '0987654321', 'tranthii@gmail.com'),
('789456123', 0, 'Pham Thi J', 'Thai Nguyen', '1999-01-30', '0976543210', 'phamthij@gmail.com'),
('147258369', 1, 'Le Van K', 'Quang Ngai', '1993-09-22', '0912345678', 'levank@gmail.com'),
('369258147', 0, 'Nguyen Thi L', 'Ha Tinh', '1986-12-03', '0965432109', 'nguyenthil@gmail.com'),
('258369147', 1, 'Tran Van M', 'Binh Dinh', '1991-05-05', '0934567890', 'tranvanm@gmail.com'),
('852963741', 0, 'Pham Van N', 'Quang Nam', '1983-04-13', '0987654321', 'phamvann@gmail.com'),
('741852963', 1, 'Le Thi O', 'Hanoi', '1988-08-18', '0912345678', 'lethio@gmail.com'),
('963852741', 0, 'Tran Van P', 'Ho Chi Minh City', '1994-03-25', '0961234567', 'tranvanp@gmail.com'),
('123123123', 1, 'Nguyen Van Q', 'Hai Phong', '1997-11-02', '0977654321', 'nguyenvanq@gmail.com'),
('789456123', 0, 'Tran Thi R', 'Ha Long', '1993-11-23', '0987654321', 'tranthir@gmail.com');
INSERT INTO customers (citizenIDNumber, gender, fullname, location, birthDate, phone, EMAIL) VALUES
('369852147', 1, 'Nguyen Thi S', 'Bac Ninh', '1988-10-15', '0961234567', 'nguyenthis@gmail.com'),
('159753456', 0, 'Le Thi T', 'Phu Yen', '1990-02-28', '0977654321', 'lethit@gmail.com'),
('753951456', 0, 'Pham Thi U', 'Hai Duong', '1995-06-09', '0912345678', 'phamthiu@gmail.com');
INSERT INTO customers (citizenIDNumber, gender, fullname, location, birthDate, phone, EMAIL) VALUES
('459789321', 1, 'Tran Thi V', 'Ninh Binh', '1989-09-01', '0981888888', 'tranthiv1@gmail.com'),
('123456987', 0, 'Nguyen Thi X', 'Hoa Binh', '1998-04-10', '0976543210', 'nguyenthix@gmail.com'),
('789456321', 0, 'Le Thi Y', 'Tien Giang', '1986-03-22', '0987654321', 'lethiy@gmail.com'),
('369852147', 0, 'Pham Thi Z', 'Long An', '1991-08-02', '0912345678', 'phamthiz@gmail.com'),
('258369147', 0, 'Tran Thi A1', 'Ha Giang', '1994-12-25', '0965432109', 'tranthia1@gmail.com'),
('741852963', 0, 'Nguyen Thi B1', 'Ben Tre', '1984-07-07', '0934567890', 'nguyenthib1@gmail.com');
INSERT INTO `customers` (`citizenIDNumber`, `fullname`, `location`, `phone`) VALUES
('cus1', 'ram1', 'ktm', '12345678901'),
('cus2', 'ram2', 'ktm', '12345678901'),
('cus3', 'ram3', 'ktm', '12345678901'),
('cus4', 'ram4', 'ktm', '12345678901'),
('cus5', 'ram5', 'ktm', '12345678901'),
('cus6', 'ram6', 'ktm', '12345678901');
INSERT INTO `customers` (`citizenIDNumber`, `fullname`, `location`, `phone`) VALUES
('cus7', 'abc', 'ktm', '12345678901'),
('cus8', 'ropd', 'ktm', '12345678901'),
('cus9', 'emcs', 'ktm', '12345678901');
--
INSERT INTO staff (fullname, staffIDCard, position, phone, email, joinDate, location, basicSalary, gender, BIRTHDATE) VALUES
('Nguyễn Văn A', '123456789', 'Nhân viên kinh doanh', '0987654321', 'nva@gmail.com', '2022-01-01 08:00:00', 'Hà Nội', 15000000, 1, '2000-01-01'),
('Trần Thị B', '987654321', 'Quản lý nhân sự', '0123456789', 'ttb@gmail.com', '2022-02-01 08:00:00', 'Hồ Chí Minh', 20000000, 0, '1999-02-01'),
('Lê Hoàng C', '456789123', 'Kế toán trưởng', '0912345678', 'lhc@gmail.com', '2022-03-01 08:00:00', 'Đà Nẵng', 25000000, 1, '1998-03-01'),
('Phạm Thanh D', '789123456', 'Nhân viên kỹ thuật', '0845678901', 'ptd@gmail.com', '2022-04-01 08:00:00', 'Hải Phòng', 18000000, 1, '1997-04-01'),
('Ngô Thị E', '369258147', 'Giám đốc điều hành', '0932108642', 'nte@gmail.com', '2022-05-01 08:00:00', 'Cần Thơ', 50000000, 0, '1996-05-01'),
('Đỗ Văn F', '258147369', 'Chuyên viên tài chính', '0968432190', 'dvf@gmail.com', '2022-06-01 08:00:00', 'Hà Nội', 22000000, 1, '1995-06-01'),
('Bùi Thị G', '741852963', 'Nhân viên bán hàng', '0975318642', 'btg@gmail.com', '2022-07-01 08:00:00', 'Hồ Chí Minh', 16000000, 0, '1994-07-01'),
('Lương Văn H', '963852741', 'Chuyên viên marketing', '0987654321', 'lvh@gmail.com', '2022-08-01 08:00:00', 'Đà Nẵng', 23000000, 1, '1993-08-01'),
('Trương Thị I', '123789456', 'Trưởng phòng kinh doanh', '0123456789', 'tti@gmail.com', '2022-09-01 08:00:00', 'Hải Phòng', 28000000, 0, '1992-09-01'),
('Cao Thị K', '789456123', 'Nhân viên tuyển dụng', '0845678901', 'ctk@gmail.com', '2022-11-01 08:00:00', 'Cần Thơ', 17000000, 0, '1991-10-01'),
('Hà Văn L', '369852147', 'Chuyên viên IT', '0932108642', 'hvl@gmail.com', '2022-12-01 08:00:00', 'Hà Nội', 25000000, 1, '1990-11-01'),
('Trần Văn M', '258963147', 'Nhân viên kinh doanh', '0968432190', 'tvm@gmail.com', '2023-01-01 08:00:00', 'Hồ Chí Minh', 19000000, 1, '1989-12-01'),
('Đặng Thị N', '741369852', 'Chuyên viên tài chính', '0975318642', 'dtn@gmail.com', '2023-02-01 08:00:00', 'Đà Nẵng', 24000000, 0, '1988-01-01'),
('Vương Văn O', '963741852', 'Giám đốc tài chính', '0987654321', 'vvo@gmail.com', '2023-03-01 08:00:00', 'Hải Phòng', 60000000, 1, '1987-02-01'),
('Phạm Thị P', '456789123', 'Nhân viên marketing', '0967891234', 'ptp@gmail.com', '2023-04-01 08:00:00', 'Hà Nội', 18000000, 0, '1992-03-01'),
('Nguyễn Thị Q', '123789456', 'Chuyên viên bảo vệ', '0905123456', 'ntq@gmail.com', '2023-05-01 08:00:00', 'Hồ Chí Minh', 15000000, 0, '1991-04-01'),
('Lê Văn R', '789123456', 'Nhân viên văn phòng', '0934567891', 'lvr@gmail.com', '2023-06-01 08:00:00', 'Đà Nẵng', 16000000, 1, '1990-05-01'),
('Đỗ Thị S', '369258147', 'Chuyên viên kế toán', '0912345678', 'dts@gmail.com', '2023-07-01 08:00:00', 'Hải Phòng', 22000000, 0, '1989-06-01'),
('Trần Văn T', '987654321', 'Quản lý sản xuất', '0976543210', 'tvt@gmail.com', '2023-08-01 08:00:00', 'Cần Thơ', 30000000, 1, '1988-07-01'),
('Nguyễn Thị U', '852369741', 'Nhân viên kinh doanh', '0987654321', 'ntu@gmail.com', '2023-09-01 08:00:00', 'Hà Nội', 18000000, 0, '1987-08-01'),
('Phạm Văn V', '159357852', 'Chuyên viên tài chính', '0963123456', 'pvv@gmail.com', '2023-10-01 08:00:00', 'Hồ Chí Minh', 20000000, 1, '1986-09-01'),
('Lê Thị W', '456123789', 'Nhân viên bảo trì', '0931234567', 'ltw@gmail.com', '2023-11-01 08:00:00', 'Đà Nẵng', 17000000, 0, '1985-10-01'),
('Đặng Văn X', '369852147', 'Chuyên viên nhân sự', '0913456789', 'dvx@gmail.com', '2023-12-01 08:00:00', 'Hải Phòng', 21000000, 1, '1984-11-01'),
('Trần Thị Y', '987654321', 'Quản lý kinh doanh', '0987654321', 'tty@gmail.com', '2024-01-01 08:00:00', 'Cần Thơ', 35000000, 0, '1983-12-01'),
('Vũ Thị Z', '123456789', 'Nhân viên bán hàng', '0912345678', 'vtz@gmail.com', '2024-02-01 08:00:00', 'Bình Dương', 15000000, 0, '1982-01-01'),
('Nguyễn Văn A1', '456789123', 'Chuyên viên kỹ thuật', '0934567891', 'nva1@gmail.com', '2024-03-01 08:00:00', 'Hải Dương', 22000000, 1, '1981-02-01'),
('Phạm Thị B1', '789123456', 'Quản lý sản xuất', '0967891234', 'ptb1@gmail.com', '2024-04-01 08:00:00', 'Hồ Chí Minh', 30000000, 0, '1980-03-01'),
('Lê Văn C1', '369258147', 'Chuyên viên kinh doanh', '0912345678', 'lvc1@gmail.com', '2024-05-01 08:00:00', 'Đà Nẵng', 20000000, 1, '1979-04-01'),
('Trần Thị D1', '147258369', 'Quản lý nhân sự', '0987654321', 'ttd1@gmail.com', '2024-06-01 08:00:00', 'Hà Nội', 35000000, 0, '1978-05-01');

INSERT INTO staff (fullname, staffIDCard, position, phone, joinDate, basicSalary)
VALUES
('Nguyễn Văn A', 'NV001', 'Nhân viên bán hàng', '0901234567', '2022-01-01', 150000),
('Trần Thị B', 'NV002', 'Quản lý cửa hàng', '0902345678', '2021-07-01', 200000),
('Lê Văn C', 'NV003', 'Nhân viên bán hàng', '0903456789', '2021-10-01', 120000),
('Phạm Thị D', 'NV004', 'Nhân viên vệ sinh', '0904567890', '2022-02-01', 90000),
('Trần Văn E', 'NV005', 'Nhân viên bán hàng', '0905678901', '2022-03-01', 140000),
('Nguyễn Thị F', 'NV006', 'Nhân viên vệ sinh', '0906789012', '2021-08-01', 90000),
('Lê Văn G', 'NV007', 'Nhân viên bảo vệ', '0907890123', '2021-12-01', 100000),
('Phạm Văn H', 'NV008', 'Nhân viên bán hàng', '0908901234', '2021-09-01', 130000),
('Nguyễn Thị I', 'NV009', 'Nhân viên bán hàng', '0909012345', '2022-04-01', 160000),
('Trần Văn K', 'NV010', 'Nhân viên vệ sinh', '0900123456', '2021-06-01', 80000),
('Lê Thị L', 'NV011', 'Nhân viên bảo vệ', '0901234567', '2021-11-01', 110000),
('Phạm Văn M', 'NV012', 'Nhân viên bán hàng', '0902345678', '2022-05-01', 170000);
--
INSERT INTO monthly_salary (staffid, monthSalary, workingHours, overtimeHours, allowance, deduction) VALUES
(4, '2022-01-01', 160, 60, 500.00, 100.00),
    (5, '2022-02-01', 165, 65, 550.00, 100.00),
    (6, '2022-03-01', 170, 70, 600.00, 100.00),
    (7, '2022-04-01', 175, 75, 650.00, 100.00),
    (8, '2022-05-01', 180, 80, 700.00, 100.00),
    (9, '2022-06-01', 185, 85, 750.00, 100.00),
    (10, '2022-07-01', 190, 90, 800.00, 100.00),
    (11, '2022-08-01', 195, 95, 850.00, 100.00),
    (12, '2022-09-01', 200, 100, 900.00, 100.00),
    (13, '2022-10-01', 205, 105, 950.00, 100.00),
    (14, '2022-11-01', 210, 110, 1000.00, 100.00),
    (15, '2022-12-01', 215, 115, 1050.00, 100.00),
    (16, '2023-01-01', 220, 120, 1100.00, 100.00),
    (17, '2023-02-01', 225, 125, 1150.00, 100.00),
    (18, '2023-03-01', 230, 130, 1200.00, 100.00),
    (19, '2023-04-01', 235, 135, 1250.00, 100.00),
    (20, '2023-01-01', 240, 140, 1300.00, 100.00),
    (21, '2023-02-01', 245, 145, 1350.00, 100.00),
    (22, '2023-03-01', 250, 150, 1400.00, 100.00),
    (23, '2023-04-01', 255, 155, 1450.00, 100.00),
    (24, '2022-01-01', 170, 70, 500.00, 100.00),
    (25, '2022-02-01', 175, 75, 550.00, 100.00),
    (26, '2022-03-01', 180, 80, 600.00, 100.00),
    (27, '2022-04-01', 185, 85, 650.00, 100.00),
    (28, '2022-05-01', 190, 90, 700.00, 100.00),
    (29, '2022-06-01', 195, 95, 750.00, 100.00),
    (30, '2022-07-01', 200, 100, 800.00, 100.00),
    (31, '2022-08-01', 205, 105, 850.00, 100.00),
    (32, '2022-09-01', 210, 110, 900.00, 100.00),
    (33, '2022-10-01', 215, 115, 950.00, 100.00),
    (34, '2022-11-01', 220, 120, 1000.00, 100.00),
    (35, '2022-12-01', 225, 125, 1050.00, 100.00),
    (36, '2023-01-01', 230, 130, 1100.00, 100.00),
    (37, '2023-02-01', 235, 135, 1150.00, 100.00),
    (38, '2023-03-01', 240, 140, 1200.00, 100.00),
    (39, '2023-04-01', 245, 145, 1250.00, 100.00),
    (40, '2023-01-01', 250, 150, 1300.00, 100.00),
    (41, '2023-02-01', 255, 155, 1350.00, 100.00);
INSERT INTO monthly_salary (staffid, monthSalary, workingHours, overtimeHours, allowance, deduction)
VALUES (1, '2022-01-01', 176, 8, 1000000, 500000),
       (2, '2022-01-01', 150, 6, 800000, 200000),
       (3, '2022-01-01', 120, 5, 500000, 100000);

--
INSERT INTO bill (billCode, purchaseDate,customerID, staffID, revenue)
VALUES
('HDX003', '2022-01-03 09:15:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 750000.0),
('HDX004', '2022-01-04 16:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 4200000.0),
('HDX005', '2022-01-05 11:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 350000.0),
('HDX006', '2022-01-06 13:10:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 860000.0),
('HDX007', '2022-01-07 08:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2500000.0),
('HDX008', '2022-01-08 17:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 630000.0),
('HDX009', '2022-01-09 11:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 4800000.0),
('HDX010', '2022-01-10 09:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1700000.0),
('HDX011', '2022-01-11 15:40:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 990000.0),
('HDX012', '2022-01-12 12:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 420000.0),
('HDX013', '2022-01-13 07:50:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 680000.0),
('HDX014', '2022-01-14 18:15:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1300000.0),
('HDX015', '2022-01-15 16:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 800000.0),
('HDX016', '2022-01-16 14:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1500000.0),
('HDX017', '2022-01-17 09:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 700000.0),
('HDX018', '2022-01-18 12:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 960000.0),
('HDX019', '2022-01-19 16:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2800000.0),
('HDX020', '2022-01-20 10:15:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 550000.0),
('HDX021', '2022-01-21 13:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 620000.0),
('HDX022', '2022-01-22 11:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1700000.0),
('HDX023', '2022-01-23 10:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2900000.0),
('HDX024', '2022-01-24 14:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1200000.0),
('HDX025', '2022-01-25 09:10:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 980000.0),
('HDX026', '2022-01-26 12:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 450000.0),
('HDX027', '2022-01-27 15:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 550000.0),
('HDX028', '2022-01-28 08:15:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1600000.0),
('HDX029', '2022-01-29 17:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 700000.0),
('HDX030', '2022-01-30 16:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2100000.0),
('HDX031', '2022-02-01 09:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1200000.0),
('HDX032', '2022-02-02 14:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 930000.0),
('HDX033', '2022-02-03 11:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2700000.0),
('HDX034', '2022-02-04 12:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 690000.0),
('HDX035', '2022-02-05 15:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1700000.0),
('HDX036', '2022-02-06 10:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1400000.0),
('HDX037', '2022-02-07 13:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 750000.0),
('HDX038', '2022-02-08 14:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 480000.0),
('HDX039', '2022-02-09 16:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2100000.0),
('HDX040', '2022-02-10 11:15:00', FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1,980000.0),
('HDX041', '2022-02-11 12:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 530000.0),
('HDX042', '2022-02-12 15:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1700000.0),
('HDX043', '2022-02-13 10:15:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2900000.0),
('HDX044', '2022-02-14 11:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 800000.0),
('HDX045', '2022-02-15 14:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 960000.0),
('HDX046', '2022-02-16 09:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 550000.0),
('HDX047', '2022-02-17 16:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2400000.0),
('HDX048', '2022-02-18 12:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 620000.0),
('HDX049', '2022-02-19 10:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1700000.0),
('HDX050', '2022-02-20 14:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2900000.0),
('HDX051', '2022-02-21 13:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 800000.0),
('HDX052', '2022-02-22 15:00:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1600000.0),
('HDX053', '2022-02-23 09:45:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 750000.0),
('HDX054', '2022-02-24 11:20:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 480000.0),
('HDX055', '2022-02-25 14:30:00',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2100000.0),
('HDX056', '2022-01-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2000000.0),
('HDX057', '2022-02-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1500000.0),
('HDX058', '2022-03-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 500000.0),
('HDX059', '2022-04-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1800000.0),
('HDX060', '2022-05-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1,  700000.0);
INSERT INTO bill (billCode, purchaseDate,customerID, staffID, revenue)
VALUES
('HDX061', '2022-06-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 3000000.0),
('HDX062','2022-07-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 900000.0),
('HDX063', '2022-08-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1200000.0),
('HDX064', '2022-09-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2500000.0),
('HDX065', '2022-10-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 3500000.0),
('HDX066', '2022-11-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 800000.0),
('HDX067', '2022-12-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1700000.0),
('HDX068', '2022-01-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 600000.0),
('HDX069', '2022-02-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1200000.0),
('HDX070', '2022-03-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 900000.0),
('HDX071', '2022-04-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 4500000.0),
('HDX072', '2022-05-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1500000.0),
('HDX073', '2022-06-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 800000.0),
('HDX074', '2022-07-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2000000.0),
('HDX076', '2023-01-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1500000.0),
('HDX077', '2023-01-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 900000.0),
('HDX078', '2023-02-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2000000.0),
('HDX079', '2023-03-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1200000.0),
('HDX080', '2023-03-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 500000.0),
('HDX081', '2023-04-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 2500000.0),
('HDX082', '2023-04-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 1800000.0),
('HDX083', '2023-05-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 800000.0),
('HDX084', '2023-05-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 3500000.0),
('HDX085', '2023-05-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1, 700000.0);
INSERT INTO bill (billCode, purchaseDate,customerID, staffID)
VALUES
  ('1', '2023-05-01',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1),
  ('2', '2023-05-02',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1),
  ('3', '2023-05-03',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1),
  ('4', '2023-05-04',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1),
  ('5', '2023-05-05',FLOOR(RAND() * 48) + 1, FLOOR(RAND() * 40) + 1);
--
DELIMITER $$
CREATE PROCEDURE insert_detailbill()
BEGIN
  DECLARE i INT DEFAULT 1;
  
  WHILE i <= 10000 DO
    INSERT INTO detailbill (billID, productID, quantity,currentPrice) 
    VALUES 
      (FLOOR(RAND() * 86) + 1, FLOOR(RAND() * 79) + 1,  FLOOR(RAND() * 30) + 1,Floor(RAND() * (300000 - 30000) + 30000));
    SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;

Call insert_detailbill();
-- 




    
    

