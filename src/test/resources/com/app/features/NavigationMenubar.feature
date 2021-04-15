# language: fr
# Author: Muana Kimba
Fonctionnalité: Affichage de la barre de menus de navigation
  En tant qu'administrateur, je désire pouvoir me retrouver à travers les menus
  ainsi que leurs sous-menus dans la barre de navigation pour mieux gérer mes sites web.

  Contexte: Je suis déjà connecté
    Soit je suis connecté à l'application

  @Fumée @Navigation @Nominal
  Scénario: Vérifier l'affichage des menus de navigation
    Alors les menus de navigation suivants doivent être affichés:
      | DASHBOARD                  |
      | SALES                      |
      | CATALOG                    |
      | CUSTOMERS                  |
      | MARKETING                  |
      | CONTENT                    |
      | REPORTS                    |
      | STORES                     |
      | SYSTEM                     |
      | FIND PARTNERS & EXTENSIONS |

  @Fumée @Navigation @Nominal
  Plan du Scénario: Vérifier l'affichage des sous-menus de navigation
    Quand je clique sur le menu de navigation "<menu>"
    Alors ses sous-menus, compris dans le fichier "navSubmenus.json", doivent s'afficher sous le(s) titre(s) "<titre_sous-menu>"

    Exemples: 
      | menu      | titre_sous-menu                                                                                        |
      | SALES     | Sales                                                                                                  |
      | CATALOG   | Catalog                                                                                                |
      | CUSTOMERS | Customers                                                                                              |
      | MARKETING | Promotions, Communications, SEO & Search, User Content, Customer Engagement                            |
      | CONTENT   | Elements, Design                                                                                       |
      | REPORTS   | Marketing, Reviews, Sales, Customers, Products, Statistics, Business Intelligence, Customer Engagement |
      | STORES    | Settings, Inventory, Taxes, Currency, Attributes                                                       |
      | SYSTEM    | Data Transfer, Extensions, Tools, Permissions, Action Logs, Other Settings                             |
