CREATE TABLE IF NOT EXISTS restaurant(
                                         restaurant_id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    address varchar(200) NOT NULL
    );