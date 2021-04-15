# language: fr
# Author: Muana Kimba
Fonctionnalité: Déconnexion
  En tant qu'administrateur, je désire pouvoir me déconnecter de l'application.

  @Fumée @Déconnexion @Nominal
  Scénario: Vérifier la déconnexion
    Soit je suis connecté à l'application
    Quand je me déconnecte de l'application
    Alors je suis sur la page de connexion
    Et un message confirmant la déconnexion est affiché
