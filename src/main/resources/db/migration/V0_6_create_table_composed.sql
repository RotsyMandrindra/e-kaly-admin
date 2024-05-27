CREATE TABLE IF NOT EXISTS composed (
                                        menu_id UUID REFERENCES menu(menu_id),
    ingredient_id UUID REFERENCES ingredient(ingredient_id),
    PRIMARY KEY (menu_id, ingredient_id),
    quantity_required double precision NOT NULL
    );