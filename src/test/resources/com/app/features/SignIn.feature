# language: fr
# Author: Muana Kimba
# Cette fonctionnalité ne peut pas être testée lorsque les deux identifiants sont invalides
# et non vide, car l'application à un nombre limité de tentatives avant que l'utilisateur
# ait à résoudre un CAPTCHA.
Fonctionnalité: Connexion
  En tant qu'administrateur, je désire pouvoir me connecter à l'application.

  Contexte: Ouvrir l'application
    Soit un navigateur est ouvert
    Quand je me rend sur le site admin de l'application
    Alors je suis sur la page de connexion

  @Fumée @Connexion @Nominal
  Scénario: Vérifier la connexion avec un nom d'utilisateur et un mot de passe valides
    Quand je me connecte avec les identifiants suivants:
      | nom_utilisateur | mot_de_passe |
      | user            | bitnami1     |
    Alors je suis sur la page du tableau de bord

  @Fumée @Connexion @Exception
  Plan du Scénario: Vérifier la connexion avec un nom d'utilisateur invalide et un mot de passe valide
    Quand je me connecte avec le nom d'utilisateur "<nom_utilisateur>" et le mot de passe "bitnami1"
    Alors un message d'erreur concernant le nom d'utilisateur s'affiche

    Exemples: 
      | nom_utilisateur |
      |                 |

  @Fumée @Connexion @Exception
  Plan du Scénario: Vérifier la connexion avec un nom d'utilisateur valide et un mot de passe invalide
    Quand je me connecte avec le nom d'utilisateur "user" et le mot de passe "<mot_de_passe>"
    Alors un message d'erreur concernant le mot de passe s'affiche

    Exemples: 
      | mot_de_passe |
      |              |

  @Fumée @Connexion @Exception
  Plan du Scénario: Vérifier la connexion avec un nom d'utilisateur et un mot de passe invalides
    Quand je me connecte avec le nom d'utilisateur "<nom_utilisateur>" et le mot de passe "<mot_de_passe>"
    Alors un message d'erreur concernant le nom d'utilisateur s'affiche
    Et un message d'erreur concernant le mot de passe s'affiche

    Exemples: 
      | nom_utilisateur | mot_de_passe |
      |                 |              |
