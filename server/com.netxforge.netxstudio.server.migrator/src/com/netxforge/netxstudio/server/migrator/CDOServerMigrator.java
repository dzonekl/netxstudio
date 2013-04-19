package com.netxforge.netxstudio.server.migrator;

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.filter;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.fromSide;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.hasConflict;

import java.util.List;

import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.spi.server.InternalRepository;
import org.eclipse.emf.compare.ConflictKind;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * Applies a
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class CDOServerMigrator {

	private InternalRepository repository;
	private List<Diff> differences;

	public CDOServerMigrator(IRepository repository, List<Diff> diferences) {
		this.repository = (InternalRepository) repository;
		this.differences = diferences;
	}

	public final IRepository getRepository() {
		return repository;
	}

	public void migrateAll() {

		// Futher processin of diffs:
		Predicate<? super Diff> predicate = and(
				fromSide(DifferenceSource.LEFT),
				not(hasConflict(ConflictKind.REAL, ConflictKind.PSEUDO)));

		Iterable<Diff> nonConflictualDifferencesFromRight = filter(differences,
				predicate);
		
		differences = Lists.newArrayList(nonConflictualDifferencesFromRight);
		for (Diff diff : differences) {
			_processDiff(diff);
		}
	}

	/**
	 * Each diff will have a LEFT, which is our current CDO Repository. The LEFT
	 * 
	 * @param diff
	 */
	protected void _processDiff(Diff diff) {

		System.out.println("Processing diff..." + diff.hashCode());
		switch (diff.getKind().getValue()) {

		case DifferenceKind.ADD_VALUE: {
			_processAdd(diff);
		}
			break;
		case DifferenceKind.CHANGE_VALUE: {
			_processChange(diff);
		}
			break;
		case DifferenceKind.DELETE_VALUE: {
			_processDelete(diff);
		}
			break;
		case DifferenceKind.MOVE_VALUE: {
			_processMove(diff);
		}
			break;

		}
	}

	private void _processAdd(Diff diff) {
		System.out.println("ADDITIONS");
		_printDiff(diff);
	}

	private void _processDelete(Diff diff) {
		System.out.println("DELETIONS");
		_printDiff(diff);
	}

	private void _processChange(Diff diff) {
		System.out.println("CHANGES");
		_printDiff(diff);
	}

	private void _processMove(Diff diff) {
		System.out.println("MOVES");
		_printDiff(diff);
	}

	/**
	 * @param diff
	 */
	private void _printDiff(Diff diff) {

		DifferenceSource src = diff.getSource();

		Match match = diff.getMatch();

		EObject left = match.getLeft();
		EObject right = match.getRight();

		if (src == DifferenceSource.LEFT) {
			System.out.println("DIFF-LEFT:");
			System.out.println(" L: " + left);
			System.out.println(" R: " + right);
		} else if (src == DifferenceSource.RIGHT) {
			System.out.println("DIFF-RIGHT:");
			System.out.println(" L: " + left);
			System.out.println(" R: " + right);
		}
	}

}
