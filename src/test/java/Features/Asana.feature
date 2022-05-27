Feature: Testing New Asana project

  Scenario: Get workspace details: gid
    Given I have workspace object
    When  User perform astana GET workspace operation
    Then  User is able to see response with workspace details


  Scenario: Post new project object
    Given : I have project object
    When  User perform astana POST workspace operation
    Then  User is able to see response with project details

#  Scenario: Get projects for workspace
#    Given

#  E2E business flow:
#    1. POST - tworzymy entity np. projekt (status+czas+body validation) - stąd id używamy do geta niżej
#    2. GET - pobieramy entity
#    3. PUT - zmieniamy entity
#    4. GET - pobieramy zmienione ENTITY
#    5. DELETE entity (url, id)
  # 6. GET - pobieramy entity i spodizewamy się że nie ma już tego resourca

