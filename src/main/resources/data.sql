SET @zooId = 1;

SET @smallEnclosureSize = 5;
SET @mediumEnclosureSize = 10;
SET @largeEnclosureSize = 15;
SET @hugeEnclosureSize = 20;

SET @inside = 0;
SET @outside = 1;

INSERT IGNORE INTO zoodb.zoo (id)
VALUES (@zooId);

INSERT IGNORE INTO zoodb.enclosure (enclosure_size, location, name, zoo_id)
VALUES
    (@largeEnclosureSize, @outside, 'Enclosure 1', @zooId),
    (@mediumEnclosureSize, @outside, 'Enclosure 2', @zooId),
    (@hugeEnclosureSize, @outside, 'Enclosure 3', @zooId),
    (@largeEnclosureSize, @outside, 'Enclosure 4', @zooId),
    (@mediumEnclosureSize, @inside, 'Enclosure 5', @zooId),
    (@smallEnclosureSize, @inside, 'Enclosure 6', @zooId);

INSERT IGNORE INTO zoodb.enclosure_object(name, enclosure_id)
VALUES
    ('Rocks',1),
    ('Logs',1),
    ('Water Pond',1),
    ('Climbing Structures',2),
    ('Shelter',2),
    ('Pool',2),
    ('Trees',3),
    ('Mud Bath Area',3),
    ('Water Trough',3),
    ('Tall Trees',4),
    ('Feeding Platform',4),
    ('Shade Structure',4),
    ('Tunnels',5),
    ('Climbing Structures',5),
    ('Enrichment Toys',5),
    ('Nesting Boxes',6),
    ('Perches',6),
    ('Swing',6)