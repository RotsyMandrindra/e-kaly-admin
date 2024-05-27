CREATE TABLE IF NOT EXISTS quantity (
                                        quantity_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    quantity_name varchar(50) NOT NULL
    );