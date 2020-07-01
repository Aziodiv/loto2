package com.bta.loto.service;

import com.bta.loto.model.Bet;
import com.bta.loto.model.PlayResult;
import com.bta.loto.repository.BetRepository;
import com.bta.loto.repository.PlayResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PlayService {
    private static final int COUNT = 6;
    private static final int MIN = 0;
    private static final int MAX = 48;

    @Autowired
    private PlayResultRepository playResultRepository;

    @Autowired
    private BetRepository betRepository;


    ///6 from 48
    public void play() {
        final Set<Integer> result = new HashSet<>(10);
        while (result.size() < COUNT) {
            result.add(getRandom());
        }
        for (int i = 0; i < 6; i++) {
            int random = getRandom();
            result.add(random);

        }

        PlayResult playResult = new PlayResult();
        playResult.setDateTime(LocalDateTime.now());

        final List<Integer> resultList = new ArrayList<>(result);
        playResult.setNumber1(resultList.get(0));
        playResult.setNumber2(resultList.get(1));
        playResult.setNumber3(resultList.get(2));
        playResult.setNumber4(resultList.get(3));
        playResult.setNumber5(resultList.get(4));
        playResult.setNumber6(resultList.get(5));
        playResultRepository.save(playResult);

        final List<Bet> activeBets = betRepository.findAllActive();

        Bet betOne = activeBets.get(0);
        final List<Integer> collectionFromBet = getCollectionFromBet(betOne);
        final List<Integer> collectionResult = getCollectionResult(playResult);


        int winNumberCount = 0;
        for (int i = 0; i < COUNT; i++) {
            if (collectionFromBet.contains(collectionResult.get(i))) {
                winNumberCount++;
            }
        }


        int winNumbersCount = COUNT - collectionFromBet.size();

        switch (winNumbersCount) {
            case 2:
                System.out.println("You win 200 EURO's!!!");
                break;
            case 3:
                System.out.println("You win 400 EURO's!!!");
                break;
            case 4:
                System.out.println("You win 1000 EURO's!!!");
                break;
            case 5:
                System.out.println("You win 5000 EURO's!!!");
                break;
            case 6:
                System.out.println("Jack POT! ");
                break;
            default:
                System.out.println("You will win Next time!!!");
        }
        betOne.setActive(false);
        betRepository.update(betOne);

    }

    private int getRandom() {
        return (int) (Math.random() * (MAX - MIN) + MIN);
    }

    private List<Integer> getCollectionFromBet(Bet bet) {
        return Arrays.asList(bet.getNumber1(), bet.getNumber2(), bet.getNumber3(),
                bet.getNumber4(), bet.getNumber5(), bet.getNumber6());
    }

    private List<Integer> getCollectionResult(PlayResult result) {
        return Arrays.asList(result.getNumber1(), result.getNumber2(), result.getNumber3(),
                result.getNumber4(), result.getNumber5(), result.getNumber6());

    }
}