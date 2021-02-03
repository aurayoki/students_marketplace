# пока неполучилось подключить, запускайте через консоль воркбэнч
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('1', 'Транспорт');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('2', 'Недвижимость');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('3', 'Работа');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('4', 'Услуги');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('5', 'Личные вещи');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('6', 'Для дома и дачи');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('7', 'Бытовая электроника');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('8', 'Хобби и отдых');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('9', 'Животные');
INSERT INTO `marketplace`.`good_category` (`id`, `name`) VALUES ('10', 'Готовый бизнес и оборудование');

INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('1', 'Аудио и видео', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('2', 'Игры, приставки и программы', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('3', 'Настольные компьютеры', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('4', 'Ноутбуки', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('5', 'Оргтехника и расходника', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('6', 'Планшеты и электронные книги', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('7', 'Телефоны', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('8', 'Товары для компьютера', '7');
INSERT INTO `marketplace`.`good_subcategory` (`id`, `name`, `good_category_id`) VALUES ('9', 'Фототехника', '7');

INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('1', 'Акустика', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('2', 'Веб-камеры', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('3', 'Джойстики и рули', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('4', 'Клавиатуры и мыши', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('5', 'Комплектующие', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('6', 'Мониторы', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('7', 'Переносные жесткие диски', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('8', 'Сетевое оборудование', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('9', 'ТВ-тюнеры', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('10', 'Флешки и карты памяти', '8');
INSERT INTO `marketplace`.`good_type` (`id`, `name`, `good_subcategory_id`) VALUES ('11', 'Аксессуары', '8');

INSERT INTO `marketplace`.`advertisement` (`id`, `description`, `name`, `price`, `good_category_id`, `good_subcategory_id`, `good_type_id`) VALUES ('1', 'В идеальном состоянии включался один раз', 'Компьютер AMD', '16000', '7', '8', '5');
INSERT INTO `marketplace`.`advertisement` (`id`, `description`, `name`, `price`, `good_category_id`, `good_subcategory_id`, `good_type_id`) VALUES ('2', 'AM4', 'Материнская плата', '18000', '7', '8', '5');
INSERT INTO `marketplace`.`advertisement` (`id`, `description`, `name`, `price`, `good_category_id`, `good_subcategory_id`, `good_type_id`) VALUES ('3', 'для игр и работы', 'Ноутбук lenovo', '23000', '7', '8', '5');
INSERT INTO `marketplace`.`advertisement` (`id`, `description`, `name`, `price`, `good_category_id`, `good_subcategory_id`, `good_type_id`) VALUES ('4', 'Игровой', 'Монитор AOC CQ32', '21000', '7', '8', '5');
