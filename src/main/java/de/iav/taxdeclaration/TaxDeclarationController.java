package de.iav.taxdeclaration;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tax")
public class TaxDeclarationController {

    @PutMapping()
    public TaxDeclaration addTaxDeclaration(@RequestBody @Valid TaxDeclaration declarationToAdd) throws TaxTooHighException {
        if(declarationToAdd.paidTax() / declarationToAdd.yearlyIncomeInEuro() > 0.5){
            throw new TaxTooHighException("Paid tax ratio to the yearly income is too high.");
        }
        return declarationToAdd;
    }

    @ExceptionHandler(TaxTooHighException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ResponseBody
    Map<String, Object> handleTaxTooHighException(TaxTooHighException e) {
        Map<String, Object> errorMessage = new HashMap<>();
        errorMessage.put("reason", e.getMessage());
        errorMessage.put("timestamp", Instant.now());
        return errorMessage;
    }

}
