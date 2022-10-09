INSERT INTO birds(
    popular_name,
    scientific_name,
    color,
    localization,
    photo
  )
VALUES(
    'Águia-cinzenta',
    'Urubitinga coronata',
    'Cinza',
    'Argentina/Bolívia/Brasil',
    'https://www.ufrgs.br/faunadigitalrs/wp-content/uploads/2022/05/72-1024x1024.png'
  ) ON CONFLICT DO NOTHING;
INSERT INTO birds(
    popular_name,
    scientific_name,
    color,
    localization,
    photo
  )
VALUES(
    'Gavião-bombachinha',
    'Harpagus diodon',
    'Cinzenta',
    'Argentina/Guianas/Paraguai/Brasil',
    'https://www.ufrgs.br/faunadigitalrs/wp-content/uploads/2022/05/75-1024x1024.png'
  ) ON CONFLICT DO NOTHING;
INSERT INTO birds(
    popular_name,
    scientific_name,
    color,
    localization,
    photo
  )
VALUES(
    'Gavião-peneira',
    'Elanus leucurus',
    'Cinza Claro/Branco',
    'America do Norte/Argentina/Chile/Brasil',
    'https://www.ufrgs.br/faunadigitalrs/wp-content/uploads/2022/05/91-1024x1024.png'
  ) ON CONFLICT DO NOTHING;