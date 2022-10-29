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
VALUES('500',
       'joão-grande',
       'maguari Stork',
       'ciconia maguari',
       'Ciconiidae',
       '85',
       'Fêmea',
       'branca',
       'banhado com espelho d''água, campo alagado, campo úmido, várzeas alagadas',
       'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Maguari_Stork_%28Ciconia_maguari%29.jpg/420px-Maguari_Stork_%28Ciconia_maguari%29.jpg',
       'Sul e Extremo Norte do Brasil'
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
VALUES('501',
       'cabeça-seca',
       'wood Stork',
       'mycteria americana',
       'Ciconiidae',
       '65',
       'Macho',
       'branca',
       'banhado com espelho d''água, campo alagado, campo úmido, várzeas alagadas',
       'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/WoodStorkWhole.JPG/420px-WoodStorkWhole.JPG',
       'América Latina'
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
VALUES('502',
       'cisne-de-pescoço-preto',
       'black-necked-swan',
       'cygnus melancoryphus',
       'Anatidae',
       '80',
       'Macho',
       'branca',
       'banhado com espelho d''água, campo alagado, campo úmido, várzeas alagadas',
       'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Cygnus_Melancoryphus.jpg/420px-Cygnus_Melancoryphus.jpg',
       'Sul da América do Sul'
      ) ON CONFLICT DO NOTHING;