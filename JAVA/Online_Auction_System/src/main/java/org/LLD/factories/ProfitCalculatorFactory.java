package org.LLD.factories;

import org.LLD.constants.ProfitCalculationStrategyType;
import org.LLD.services.strategies.ProfitOrLossCalculation.ProfitCalculationStrategy;
import org.LLD.services.strategies.ProfitOrLossCalculation.impl.SimpleProfitCalculationStrategy;

public class ProfitCalculatorFactory {
    public static ProfitCalculationStrategy getStrategy(ProfitCalculationStrategyType strategyType) {
        if(strategyType.equals(ProfitCalculationStrategyType.SIMPLE)) {
            return new SimpleProfitCalculationStrategy();
        }
        return null;
    }
}
