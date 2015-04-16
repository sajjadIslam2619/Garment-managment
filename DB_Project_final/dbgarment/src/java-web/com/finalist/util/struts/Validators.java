package com.finalist.util.struts;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.Resources;
import org.apache.commons.validator.util.ValidatorUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.StringCharacterIterator;
import java.text.CharacterIterator;


/**
 * A class containing custom validators used by the Struts declarative validation framework.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public class Validators {
   private static final char DECIMAL_SEPERATOR = new DecimalFormat().getDecimalFormatSymbols().getDecimalSeparator();

   /** The value of a select field if nothing is selected. */
   public static final String NO_SELECTION = "- select -";

   /**
    * A validation to check that the user has selected an option from a select list, and
    * not simply left the dummy "select an option" option selected.
    *
    * @param bean The bean
    * @param va The va
    * @param field The field
    * @param errors The errors
    * @param request The request
    * @return <code>true</code> if a valid selection has been made.
    */
   public static boolean validateSomethingSelected(java.lang.Object bean,
                                                   org.apache.commons.validator.ValidatorAction va,
                                                   org.apache.commons.validator.Field field,
                                                   ActionErrors errors,
                                                   HttpServletRequest request) {
      String value = null;
      if (isString(bean)) {
         value = (String) bean;
      }
      else {
         value = ValidatorUtils.getValueAsString(bean, field.getProperty());
      }
      if (NO_SELECTION.equals(value)) {
         errors.add(field.getKey(),
               Resources.getActionMessage(request, va, field));

         return false;
      }

      return true;
   }

   /**
    * A validation to check that a number value is a correctly formed decimal.
    * <p>
    * This validation conforms to the Oracle 8 validation of a NUMBER with a specified
    * precision and scale.  For example, a <code>NUMBER(5,2)</code> is validated on the following points:
    * <li>The value can only consist of numbers, a decimal seperator and a positive/negative sign</li>
    * <li>There are no more than 2 decimal places (any extra decimal places are rounded off by Oracle, but
    * the validation in this method is strict and signals this as an error)</li>
    * <li>There are no more than 3 (5 - 2) numbers before the decimal point (ignoring leading zeroes)</li>
    *
    * @param bean The bean
    * @param va The va
    * @param field The field
    * @param errors The errors
    * @param request The request
    * @return <code>true</code> if a valid selection has been made.
    */
   public static boolean validateDecimal(java.lang.Object bean,
                                                   org.apache.commons.validator.ValidatorAction va,
                                                   org.apache.commons.validator.Field field,
                                                   ActionErrors errors,
                                                   HttpServletRequest request) {
      String value = null;
      if (isString(bean)) {
         value = (String) bean;
      }
      else {
         value = ValidatorUtils.getValueAsString(bean, field.getProperty());
      }
      boolean validFloat = true;
      try {
         validFloat = !(new Float(value).isNaN());
      }
      catch (NumberFormatException e) {
         validFloat = false;
      }

      int length = Integer.parseInt(field.getVarValue("decimalLength"));
      int precision = Integer.parseInt(field.getVarValue("decimalPrecision"));
      int decimalPoint = value.indexOf(DECIMAL_SEPERATOR);

      int numberCount = 0;
      StringCharacterIterator i = new StringCharacterIterator(value);
      for (char c = i.first(); c != CharacterIterator.DONE; c = i.next()) {
         if (Character.isDigit(c)
            && !(Character.digit(c, 10) == 0
            && numberCount == 0)
         ) {
            numberCount++;
         }
      }

      int decimalPlaces = decimalPoint == -1 ? 0 : value.length() - decimalPoint - 1;
      boolean validDecimal = validFloat
                             && (numberCount + (precision - decimalPlaces)) <= length
                             && decimalPlaces <= precision;

      if (!validDecimal) {
         errors.add(field.getKey(),
               Resources.getActionMessage(request, va, field));
      }

      return validDecimal;
   }


   /**
    * Return <code>true</code> if the specified object is a String or a <code>null</code>
    * value.</p>
    *
    * @param  o  Object to be tested
    * @return    The string value
    */
   private static boolean isString(Object o) {
      if (o == null) {
         return (true);
      }
      return (String.class.isInstance(o));
   }


}
