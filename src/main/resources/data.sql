INSERT INTO test_hw2.users (username, firstname, lastname, email, phone)
VALUES ('username_1', 'firstname_1', 'lastname_1', 'user_1@gmail.com', '+79001234001'),
       ('username_2', 'firstname_2', 'lastname_2', 'user_2@gmail.com', '+79001234002'),
       ('username_3', 'firstname_3', 'lastname_3', 'user_3@gmail.com', '+79001234003'),
       ('username_4', 'firstname_4', 'lastname_4', 'user_4@gmail.com', '+79001234004'),
       ('username_5', 'firstname_5', 'lastname_5', 'user_5@gmail.com', '+79001234005')
ON CONFLICT (username) DO NOTHING;
