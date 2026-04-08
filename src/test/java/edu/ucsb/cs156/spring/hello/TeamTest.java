package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team teamEqual;
    Team teamNotEqual;
    Team teamEqualDifferentMembers;
    Team teamEqualSameMembers;
    TeamTest notTeam;

    @BeforeEach
    public void setup() {
        team = new Team("test-team"); 

        teamEqual = new Team("test-team"); 
        teamNotEqual = new Team("test-team-not-equal");
        teamEqualDifferentMembers = new Team("test-team");
        teamEqualSameMembers = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test 
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_returns_true_for_same_team() {
        assert(team.equals(team));
    }

    @Test
    public void equals_false_for_different_object_type() {
        assert(!team.equals(notTeam));
    }

    @Test
    public void equals_returns_true_for_equal_teams() {
        assert(team.equals(teamEqual));
    }

    @Test
    public void equals_returns_false_for_not_equal_teams() {
        assert(!team.equals(teamNotEqual));
    }

    @Test 
    public void equals_returns_false_for_different_members() {
        teamEqualDifferentMembers.addMember("member0");
        assert(!team.equals(teamEqualDifferentMembers));
    }

    @Test
    public void equals_returns_true_for_same_members() {
        teamEqualSameMembers.addMember("member1");
        team.addMember("member1");
        assert(team.equals(teamEqualSameMembers));
    }

    @Test
    public void hashCode_returns_same_hashcode_for_equal_teams() {
        assert(team.hashCode() == teamEqualSameMembers.hashCode());
    }

    @Test
    public void correct_hashCode() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
