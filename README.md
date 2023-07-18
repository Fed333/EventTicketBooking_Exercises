# Integration Tests Practicing
This Java project focuses on implementing the application integration tests. 
The tests can be found under the `src/itest/java` location.

## Issues
The following test classes to be implemented:
- `EhCacheHibernateITest`
- `InitializeStorageWithPreparedDataBeanPostProcessorITest`
- `BookingFacadeITest`

## Requirements
- All test classes must be implemented using JUnit4.
- The project is made up of Spring and uses both xml and annotation configurations.
- The tests must be executed in a working environment with a raised application context.
- No mocks must be used.
- Use `src/main/resources/services.xml` as a configuration source.
- Use `src/main/resources/init-data/storage.json` as an initial and expected dataset.
- Use the test profile for all integration tests to make it work with the H2 in-memory database.
- AssertJ Core assertion library must be used for assertions.
- All implementations of test methods must follow the specified naming convention.

## Pay attention
The project already contains all necessary dependencies, so you are not supposed to change the `pom.xml`.