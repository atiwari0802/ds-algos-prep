package prep.ds.algo.graphs.topological.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RecipesFromSuppliesTest {

    private RecipesFromSupplies recipesFromSupplies;

    @BeforeEach
    void setUp() {
        recipesFromSupplies = new RecipesFromSupplies();
    }

    @Test
    public void testFindAllRecipes() {
        String[] recipes = {"bread", "sandwich", "burger"};
        String[][] ingredients = {{"yeast", "flour"}, {"bread", "meat"}, {"sandwich", "meat", "bread"}};
        String[] supplies = {"yeast", "flour", "meat"};

        List<List<String>> ingredientsList = Arrays.stream(ingredients)
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<String> answer = recipesFromSupplies.findAllRecipes(recipes, ingredientsList, supplies);

        Assertions.assertEquals(3, answer.size());

        answer.forEach(System.out::println);
    }
}