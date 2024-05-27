CREATE TABLE IF NOT EXISTS menu (
                                    menu_id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    menu_name varchar(200) NOT NULL,
    unit_price double precision NOT NULL,
    restaurant_id uuid REFERENCES restaurant(restaurant_id)
    );