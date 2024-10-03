package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        // Arrange
        // TODO: Initialize test data
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

        // Act
        // TODO: Call the method to be tested
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }

        // Assert
        // TODO: Verify the results
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodeResolverField() {
        // Arrange
        // TODO: Initialize test data
        String[] messageCodes = codesResolver.resolveMessageCodes("require", "item", "itemName", String.class);

        // Act
        // TODO: Call the method to be tested
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }

        // Assert
        // TODO: Verify the results
        assertThat(messageCodes).containsExactly(
                "require.item.itemName",
                "require.itemName",
                "require.java.lang.String",
                "require");
    }
}
