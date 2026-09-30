Contributing Guidelines

Thank you for contributing to the Order Management System (com.proyecto_gestion_pedidos).

The following rules should be followed when making changes to the project. They are intended to keep the code organized and make collaboration easier.

1. Branching Strategy

The project uses a simplified Git Flow workflow.

main (or master): Contains the stable version of the project.
feature/*: Used for adding new features or documenting existing code.
fix/*: Used for fixing bugs or making corrections to the documentation.

Examples:

feature/code-documentation
feature/add-discount-rules
fix/readme-improvements
fix/vat-calculation-bug

Changes should not be committed directly to main. A separate branch should be created and a Pull Request should be opened.

2. Code Style and Documentation

The project uses Java 17 or higher.

All classes, methods, constructors and fields should have Javadoc documentation written in English.

The following tags should be used when necessary:

@param for method parameters.
@return for methods that return a value.
@throws for exceptions that can be thrown.

Example:

/**
 * Calculates the total price of an order.
 *
 * @param quantity number of products
 * @param price price of each product
 * @return the total price
 * @throws IllegalArgumentException if quantity or price is negative
 */
public double calculateTotal(int quantity, double price) {
    // Implementation
}
Naming conventions

Standard Java naming conventions should be used:

Classes: PascalCase → OrderManager
Methods: camelCase → calculateTotal()
Variables: camelCase → totalPrice
Constants: UPPER_SNAKE_CASE → MAX_DISCOUNT
3. Commit Messages

Commit messages should follow the Conventional Commits format.

The main types used in the project are:

feat: New functionality.
fix: Bug fixes.
docs: Documentation changes.
style: Formatting or style changes that do not affect functionality.
refactor: Code changes that do not modify the functionality.
test: Changes or additions to tests.

Examples:

docs: add Javadoc documentation
docs: create README.md and CONTRIBUTING.md
fix: correct shipping cost calculation
feat: add discount rules
4. Pull Requests

Before creating a Pull Request, the changes should be checked first.

Self-review

Check that:

The code is correctly formatted.
The required Javadoc has been added.
Naming conventions are followed.
Tests have been run.
There are no unnecessary changes in the commit.
Pull Request title

The title should briefly describe the changes.

Example:

[Docs] Add Javadoc and repository guidelines
Pull Request description

The description should explain what has been changed and, if necessary, why the changes were made.

Review

At least one other member of the project should review the Pull Request.

The Pull Request should not be merged into main until it has been approved.

5. Contribution Process

The usual process is:

Create a new branch.
Make the required changes.
Add or update the Javadoc.
Run the tests.
Commit the changes using the correct format.
Push the branch.
Open a Pull Request.
Request a review.
Make any necessary changes.
Merge the Pull Request after approval.
6. Checklist

Before opening a Pull Request, check the following:

The changes are not made directly on main.

The branch has the correct name.

Java 17 or higher is being used.

The necessary Javadoc has been added.

Javadoc is written in English.

@param, @return and @throws are used where needed.

Java naming conventions are followed.

The commit message follows Conventional Commits.

Tests have been run.

The Pull Request has a clear title and description.

At least one reviewer has been assigned.

The Pull Request has been approved before merging.