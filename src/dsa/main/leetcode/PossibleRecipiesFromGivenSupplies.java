package dsa.main.leetcode;

import java.util.*;

public class PossibleRecipiesFromGivenSupplies {
    public static void main(String[] args) {

        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"), List.of("bread", "meat"));
        String[] supplies = {"yeast", "flour", "corn"};

        findAllRecipes(recipes, ingredients, supplies).forEach(System.out::println);
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String, Integer> ingredientCount = new HashMap<>();
        Map<String, List<String>> dependents = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> recipeIngredients = ingredients.get(i);
            ingredientCount.put(recipe, recipeIngredients.size());

            for (String ingredient : recipeIngredients) {
                dependents.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(available);

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (ingredientCount.containsKey(current)) {
                result.add(current);
            }

            if (dependents.containsKey(current)) {
                for (String dependentRecipe : dependents.get(current)) {
                    ingredientCount.put(dependentRecipe, ingredientCount.get(dependentRecipe) - 1);

                    if (ingredientCount.get(dependentRecipe) == 0) {
                        queue.add(dependentRecipe);
                        available.add(dependentRecipe);
                    }
                }
            }
        }
        return result;
    }
}
