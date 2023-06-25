insert into zoodb.zoo(id)
values(1);

insert into zoodb.enclosure(enclosure_size,location,name, zoo_id)
values(5,1,'Enclosure 1', 1),
      (10,1,'Enclosure 2', 1),
      (22,1,'Enclosure 3', 1),
      (12,1,'Enclosure 4', 1),
      (3,0,'Enclosure 5', 1),
      (9,0,'Enclosure 6', 1);


insert into zoodb.enclosure_object(name, enclosure_id)
values('Rocks',1),
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