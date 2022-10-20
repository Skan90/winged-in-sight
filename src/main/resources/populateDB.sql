INSERT INTO Bird(id,
    common_name,
    bird_order,
    family,
    genus,
    species,
    photo,
    localization
    )
VALUES('100',
    'Bald eagle',
    'Accipitriformes and Falconiformes',
    'Accipitridae',
    'Haliaeetus',
    'Haliaeetus leucocephalus',
    'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/About_to_Launch_%2826075320352%29.jpg/420px-About_to_Launch_%2826075320352%29.jpg',
    'North America'
  ) ON CONFLICT DO NOTHING;

INSERT INTO Bird(id,
    common_name,
    bird_order,
    family,
    genus,
    species,
    photo,
    localization
)
VALUES('101',
          'Great kiskadee',
          'Passeriformes',
          'Tyrannidae',
          'Pitangus',
          'Pitangus sulphuratus',
          'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Pitangus_sulphuratus_3.jpg/330px-Pitangus_sulphuratus_3.jpg',
          'South America'
      ) ON CONFLICT DO NOTHING;

INSERT INTO bird(id,
    common_name,
    bird_order,
    family,
    genus,
    species,
    photo,
    localization
)
VALUES('102',
          'Woodpecker',
          'Piciformes',
          'Picides',
          'Dryocopus',
          'Dryocopus pileatus',
          'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Pileated_Woodpecker_%289597212081%29%2C_crop.jpg/330px-Pileated_Woodpecker_%289597212081%29%2C_crop.jpg',
          'North America'
      ) ON CONFLICT DO NOTHING;