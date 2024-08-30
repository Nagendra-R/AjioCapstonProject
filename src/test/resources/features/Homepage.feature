Feature: Ecommerce functionality verification
  Scenario: verify the goto the top button is working
    Given user opens the website
    And user navigates to the bottom of the page
    When user clicks on the goto top arrow button
    Then user must reach the top of the page

  Scenario: verify customer care message is displayed properly
    Given user opens the website
    Then user clicks on customer care option
    When user select topic "Topic" and issue
    Then verify message is displayed in the get assistance section

  Scenario: verify total number of products equals the number along category
    Given user opens the website
    Then hover over men section and click on a type "cloth.type"
    When product list page is displayed select a category
    Then verify the number along the category is same as total products

  Scenario: verify selected rating is applied to the products
    Given user opens the website
    And clicks on the home and kitchen menu from the header
    When user is on home and kitchen page, click on a rating "rating.option"
    Then verify the products have the selected rating only

  Scenario: verify the grid button is working properly
    Given user opens the website
    And user clicks on the beauty menu from the homepage
    When user is on the beauty page and clicks grid button
    Then verify number of products displayed in a single row changed

  Scenario: verify every product is of the same brand
    Given user opens the website
    And user hovers above a menu in the header section
    Then hover over the brand menu option
    And select a particular brand "brand"
    When user is on the product listing page
    Then verify every product is of the selected brand only

  Scenario: verify coupons are working
    Given user opens the website
    Then user search for a product "search.product" in the search input field
    When user is on the product listing page
    Then click on a product
    And select a size for the product
    Then add the product to the cart
    And go to the cart page
    When user is on the cart page select a coupon and click apply
    Then verify the selected coupon is applied to the product

  Scenario: verify the delete button inside cart is working
    Given user opens the website
    Then user search for a product "search.product" in the search input field
    When user is on the product listing page
    Then click on a product
    And select a size for the product
    Then add the product to the cart
    And go to the cart page
    When user is on the cart page click on the delete button
    Then verify the product is removed from the cart

  Scenario: verify quantity in the cart is updating
    Given user opens the website
    Then user search for a product "search.product" in the search input field
    When user is on the product listing page
    Then click on a product
    And select a size for the product
    Then add the product to the cart
    And go to the cart page
    When user is on the cart page change the quantity of the product
    Then verify the price is changed based on quantity

    #9
  Scenario: verify add to cart won't work without selecting size
    Given user opens the website
    Then user search for a product "search.product" in the search input field
    When user is on the product listing page
    Then click on a product
    When add to cart button is clicked
    Then verify product can't be added to cart without a size





