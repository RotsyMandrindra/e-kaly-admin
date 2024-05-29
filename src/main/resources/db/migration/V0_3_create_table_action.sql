CREATE TABLE IF NOT EXISTS action (
                                      action_id UUID PRIMARY KEY,
                                      action_type varchar(50) NOT NULL,
                                      CHECK (action_type in ('Outlet', 'Supply')),
                                      stock_value double precision NOT NULL,
                                      selling_value double precision,
                                      providing_value double precision,
                                      action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);