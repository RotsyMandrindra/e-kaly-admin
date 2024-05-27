CREATE TABLE IF NOT EXISTS action (
                                      action_id UUID PRIMARY KEY,
                                      action_type varchar(50) NOT NULL,
                                      CHECK (action_type in ('Outlet', 'Supply')),
                                      stock_value double precision NOT NULL,
                                      selling_value double precision NOT NULL,
                                      providing_value double precision NOT NULL,
                                      action_date TIMESTAMP NOT NULL
);