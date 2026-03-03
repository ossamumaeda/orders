Required Features (learning-driven)
🔹 Phase 1 — Core CRUD (but correctly)

. Create customer - OK

. Create product - OK

. Create order with items - OK

. Validate stock - OK

. Decrease inventory - OK

👉 Learn:

. DTO mapping

. Transactions
 
. Collections & identity

🔹 Phase 2 — Business rules

. Prevent duplicate products in same order - OK
 
. Prevent order without items - OK

. Prevent negative stock - OK

. Order status lifecycle

👉 Learn:

. equals/hashCode

. Set behavior

. Domain logic placement

🔹 Phase 3 — Performance traps (intentional pain)

. List orders with customer + items - OK

. List orders by customers - OK

. Observe N+1 problem - OK

. Fix using:

. fetch join
 
. entity graphs
 
. projections

👉 Learn:

. Lazy loading
. JPQL
. ORM performance

🔹 Phase 4 — Error handling & robustness

. Global exception handling - OK
. Meaningful HTTP errors - OK
. Validation errors - ok

👉 Learn:

. ControllerAdvice

. API design

🔹 Phase 5 — Testing (non-negotiable)

. Unit test:
. Services
. Domain rules
. Integration test:
. Repositories
. Critical flows

👉 Learn:

. Mockito
. Test boundaries
. What not to test