CREATE TABLE IF NOT EXISTS ingredient(
                                         ingredient_id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
                                         ingredient_name varchar(200) NOT NULL,
                                         unit_price double precision NOT NULL,
                                         quantity_id uuid REFERENCES quantity(quantity_id),
                                         action_id uuid REFERENCES action(action_id)
);