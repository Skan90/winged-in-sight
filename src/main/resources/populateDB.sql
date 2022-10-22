INSERT INTO bird(id,
    name_pt_br,
    name_eng,
    species,
    family,
    size,
    gender,
    color,
    habitat,
    photo,
    localization
    )
VALUES('400',
       'João-grande',
       'Maguari Stork',
       'Ciconia maguari',
       'Ciconiidae',
       '85',
       'Fêmea',
       'Branca',
       'Banhado com espelho d''água | Campo alagado, campo úmido, várzeas alagadas',
       'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Maguari_Stork_%28Ciconia_maguari%29.jpg/420px-Maguari_Stork_%28Ciconia_maguari%29.jpg',
       'South and Extreme North of Brazil'
  ) ON CONFLICT DO NOTHING;

INSERT INTO bird(id,
                 name_pt_br,
                 name_eng,
                 species,
                 family,
                 size,
                 gender,
                 color,
                 habitat,
                 photo,
                 localization
)
VALUES('401',
       'Cabeça-seca',
       'Wood Stork',
       'Mycteria americana',
       'Ciconiidae',
       '65',
       'Macho',
       'Branca',
       'Banhado com espelho d''água | Campo alagado, campo úmido, várzeas alagadas',
       'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/WoodStorkWhole.JPG/420px-WoodStorkWhole.JPG',
       'Latin America'
      ) ON CONFLICT DO NOTHING;

INSERT INTO bird(id,
                 name_pt_br,
                 name_eng,
                 species,
                 family,
                 size,
                 gender,
                 color,
                 habitat,
                 photo,
                 localization
)
VALUES('402',
       'Cisne-de-pescoço-preto',
       'Black-necked-swan',
       'Cygnus melancoryphus',
       'Anatidae',
       '80',
       'Macho',
       'Branca',
       'Banhado com espelho d''água | Campo alagado, campo úmido, várzeas alagadas',
       'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Cygnus_Melancoryphus.jpg/420px-Cygnus_Melancoryphus.jpg',
       'South of South America'
      ) ON CONFLICT DO NOTHING;