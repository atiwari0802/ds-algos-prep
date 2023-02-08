package prep.ds.algo.graphs.topological.sort;

import java.util.*;

/**
 * You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.
 *
 * You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
 *
 * Return a list of all the recipes that you can create. You may return the answer in any order.
 *
 * Note that two recipes may contain each other in their ingredients.
 */
public class RecipesFromSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> ingredientToRecipeMap = new HashMap<>();
        Map<String, Integer> inDegreeMap = new HashMap<>();
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    ingredientToRecipeMap.computeIfAbsent(ingredient, v -> new ArrayList<>()).add(recipes[i]);
                    inDegreeMap.merge(recipes[i], 1, Integer::sum);
                }
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < recipes.length; i++) {
            if (inDegreeMap.getOrDefault(recipes[i], 0) == 0) {
                queue.addLast(recipes[i]);
            }
        }

        while (!queue.isEmpty()) {
            String recipe = queue.removeFirst();
            answer.add(recipe);

            if (ingredientToRecipeMap.containsKey(recipe)) {
                for (String rcp : ingredientToRecipeMap.get(recipe)) {
                    int inDegree = inDegreeMap.merge(rcp, -1, Integer::sum);
                    if (inDegree == 0) {
                        queue.addLast(rcp);
                    }
                }
            }
        }

        return answer;
    }
}
