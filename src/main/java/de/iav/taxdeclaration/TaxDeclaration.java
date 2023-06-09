package de.iav.taxdeclaration;

import jakarta.validation.constraints.*;

public record TaxDeclaration
        (
                @NotNull
                @NotBlank
                String name,

                @NotNull
                @NotBlank
                String address,

                @Min(0)
                //@NotBlank
                double yearlyIncomeInEuro,

                @Pattern(regexp = "\\w+\\d+")
                @NotBlank
                String socialSecurityNumber,

                boolean isChurchMember,

                @Min(0)
                //@NotBlank
                int numOfChildren,

                @Min(0)
                double paidTax

        )
{
}
